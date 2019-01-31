// 复制代码
function copyCode() {
    let code = document.querySelector('#codeBox').innerText
    console.log(code)
    let tmpTextarea = document.createElement('textarea')
    tmpTextarea.value = code
    document.body.appendChild(tmpTextarea)
    tmpTextarea.select() // 选择对象
    document.execCommand('Copy') // 执行浏览器复制命令
    tmpTextarea.parentNode.removeChild(tmpTextarea)
}

// 拖拽事件初始
function initDragAndDropEvent() {
// 拖动图片
    let picBox = document.getElementById('picBox')
    //当进入
    picBox.addEventListener('dragenter', function () {
        // console.log('可以释放元素')
    })
    //离开
    picBox.addEventListener('dragleave', function () {
        // console.log('请将图片拖拽到此区域')
    })
    //在内部移动
    picBox.addEventListener('dragover', function (e) {
        e.preventDefault()
    })
    // 释放
    picBox.addEventListener('drop', function (e) {
        e.preventDefault()
        // 获取拖过来的文件
        const fs = e.dataTransfer.files
        let len = fs.length //获取文件个数
        for (let i = 0; i < len; i++) {
            let _type = fs[i].type
            if (_type.indexOf('image') !== -1) {//判断他是不是图片文件
                let fd = new FileReader()
                fd.readAsDataURL(fs[i])
                fd.onload = function () {
                    let image = new Image()
                    image.onload = function () {
                        let canvas = $('#upload > canvas')[0]
                        let g2d = canvas.getContext('2d')
                        canvas.width = image.width
                        canvas.height = image.height
                        g2d.drawImage(image, 0, 0)
                    }
                    image.src = this.result
                }
            } else {
                console.log('请，上传图片文件！！')
            }
        }
    })
}

// 初始颜色选择器
function initColorPicker() {
    // 绑定选择颜色
    $('.color').click(function () {
        let colorName = /^[^\d]*/.exec($(this).parent().text())[0].trim() + '-' + $(this).text().trim()
        $('.colorInput').val(colorName)
        $('.openPicker').text('颜色 ' + colorName)
    })

    $('.colorInput').change(function () {
        $('.openPicker').text('颜色 ' + $(this).val())
    })

    function openPicker() {
        $('#colorPickerBox').show()
    }

    function closePicker() {
        $('#colorPickerBox').hide()
    }

    $('.openPicker').click(() => {
        openPicker()
    })
    $('.colorOk').click(() => {
        closePicker()
    })
}

// 将图片装换为代码
function tranPic() {

}

// 将图片颜色
function tranColor() {

}

// 保存文件
function saveFile(content, filename) {
    // 创建隐藏的可下载链接
    let eleLink = document.createElement('a')
    eleLink.download = filename
    eleLink.style.display = 'none'
    // 字符内容转变成blob地址
    let blob = new Blob([content])
    eleLink.href = URL.createObjectURL(blob)
    // 触发点击
    document.body.appendChild(eleLink)
    eleLink.click()
    // 然后移除
    document.body.removeChild(eleLink)
}

$(function () {
    initDragAndDropEvent()
})
