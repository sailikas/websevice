const { createApp, reactive, ref } = Vue
const app = Vue.createApp({
    setup() {

        let textareaMd = ref('')
        let pageTag = ref('相关标签')
        let randText = ref('一言api,无敌')
        // 表单校验
        let checkRegister = ref('')
        let checkRegister2 = ref('')

        let userPage = reactive({
            name: '个人中心',
            url: 'personal-alt.html'
        })
        let homePage = reactive({
            name: '主页',
            list: [{
                name: 'page1',
                url: '#'
            }, {
                name: 'page2',
                url: '#'
            }, {
                name: 'page3',
                url: '#'
            }],
            url: 'index.html'
        })
        let writePage = reactive({
            name: '写博客',
            url: 'createCtext.html'
        })
        let loginPage = reactive({
            name: '登录',
            url: 'login.html'
        })
        let registerPage = reactive({
            name: '注册',
            url: 'register.html'
        })
        let messagePage = reactive({
            name: '消息',
            url: '#'
        })
        let blogPage = reactive({
            name: '博客页面',
            url: 'blog-single.html',
            isLike: false,

            data: [
                {
                    cid: '1',
                    from: 'wofade',
                    title: '博客标题',
                    time: '随便的时间',
                    content: '这里是axios markdown占位符',
                    summarize: '简介111111111111111'
                },
                {
                    cid: '2',

                    from: '我发的',
                    title: '博客标题2',
                    time: new Date().toDateString(),
                    content: '这里是axios markdown占位符2',
                    summarize: '123132312sdadfs'
                },
                {
                    "cid": "fake_data",
                    "from": "fake_data",
                    "title": "fake_data",
                    "time": "fake_data",
                    "content": "fake_data",
                    "summarize": "fake_data"
                  }
            ],


            subText: {
                count: 3,
                data: [{
                    from: 'users',
                    time: '随便的时间',
                    content: '这里是axios markdown占位符',

                }, {
                    from: 'admin',
                    time: '随便的时间',
                    content: '这里是axios markdown占位符',

                }, {
                    from: 'users2',
                    time: '随便的时间',
                    content: '这里是axios markdown占位符',

                },]

            }

        })
        let callMePage = reactive({
            name: '联系我们',

            url: 'contact.html'
        })



        let user = reactive({
            name: '用户名',
            headImg: 'images/other/author-sm.png',
            tag: '个性签名',
            introduction: '简介不得多写点简介不得多写点简介不得多写点简介不得多写点简介不得多写点简介不得多写点',
            blog: [
                {
                    from: '哪个用户发的',
                    title: 'user发的',
                    time: new Date().toDateString(),
                    content: '这里是axios s',
                    summarize: '123132312sdadfs'
                },
                {
                    from: '哪个用户发的',
                    title: 'wod',
                    time: '1231231',
                    content: '这里是axios markdown占位符2',
                    summarize: '123132312sdadfs'
                }
            ]

        })


        let time = reactive({
            localtime: new Date().toDateString(),
            tag: '个性签名'
        })


        //周榜
        let weekTable = reactive({
            title: '啊啊啊!!啊!!',
            time: '2020-1-1'
        })
        //日榜
        let dayTable = reactive({
            title: '我的圣剑!!',
            time: '2020-0-1'
        })
        //问候语
        var timeGreet = function () {
            msg = ''
            let date = new Date();
            if (date.getHours() >= 0 && date.getHours() < 12) {

                msg = "上午好"

            } else if (date.getHours() >= 12 && date.getHours() < 18) {

                msg = "下午好"

            } else {

                msg = "晚上好"

            }
            return msg + ',' + user.name
        }

        var subText = function () {
            var textareas = $('#InputComment').val()
            $.post("http://192.168.31.182:8080/blog/add/subtext", { 'uid': 1, 'content': textareas }, function (data, status) {
                alert('发送成功')
                console.log("Data: " + data + "  nStatus: " + status);
            })
        }


        var addBlog = function () {
            // 取html markdown

            console.log("markdown=" + textareaMd.value);
            // url加/还是不加？//getLocalSession().uid
            $.post("http://192.168.31.182:8080/blog/add/content",
                {
                    'uid': getLocalSession().uid,
                    'content': {
                        markdown:textareaMd.value,
                        time:new Date().toDateString(),
                    },                    

                },
                function (data, status) {
                    alert('发送成功！')
                    console.log("Data: " + data + "  nStatus: " + status);
                })
            alert('发送成功')

        }

        var getLocalSession = function () {
            //post得到数据之后本地化存入浏览器
            // 检测session有没有需要的数据
            
            while (sessionStorage.getItem('uid')==null) {
                console.log("post session");
                var url = "http://192.168.31.182:8080/user/session";
                $.get(url, function (data, status) {
                    console.log("Data: " + data + "  nStatus: " + status);
                    var obj = eval(" (" + data + ")");
                    for (i in obj) {
                        sessionStorage.setItem(i, obj[i])
                    }

                    
                    
                })
             
            }
            return {"uid":sessionStorage.getItem('uid')}

            
        }

        var checkRegisterSubmit = function () {
            console.log("in checkRegisterSubmit");
            if (checkRegister.value == checkRegister2.value) {
                // post

                var url = "http://192.168.31.182:8080/user/register";
                var dat = new FormData()
                var email = $("#email").val()
                dat.append('email', email)
                dat.append('password', checkRegister.value)


                axios({
                    //请求类型
                    method: 'post',
                    //地址，用建好的 JSON Server地址
                    url: url,
                    data: dat
                }).then(response => {
                    console.log('axios' + response);
                })

                setTimeout(() => {
                    location = loginPage.url
                }, 2000)
                return
            }
            console.log("eee");
        }
            var getblogData = function () {
                var url = "http://192.168.31.182:8080/blog/data";
                $.get(url, function (data, status) {
                   
                    this.blogPage.data = eval(" (" + data + ")");
                    console.log(data);
                })

            }





            return {
                pageTag,
                randText,
                userPage,
                homePage,
                writePage,
                loginPage,
                registerPage,
                blogPage,
                callMePage,
                messagePage,
                user,
                time,
                weekTable,
                dayTable,
                timeGreet,
                subText,
                getLocalSession,
                addBlog,
                textareaMd,
                checkRegister,
                checkRegister2,
                checkRegisterSubmit,
                getblogData,
            }

        },
            


})
app.mount('#app')


