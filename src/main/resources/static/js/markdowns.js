
        $(function () {
            marked.setOptions({
                renderer: new marked.Renderer(),
                highlight: function (code) {
                    return createul(code.split('\n'));
                },
                pedantic: false,
                gfm: true,
                breaks: true,
                sanitize: false,
                smartLists: true,
                smartypants: false,
                xhtml: false
            });
            $("#md").on("keyup blur", function () {
                $('#html').html('<div>'+marked.parse($("#md").val())+'</div>');
                console.log('keyup');
            })
        });
        function createul(strArr) {
            let str = '';
            for (let item of strArr) {
                str += `<li>${item}</li>`;
            }
            return `<ol>${str}</ol>`
        }
    