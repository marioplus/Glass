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

    const canvas = document.querySelector('#upload > canvas')
    const w = canvas.width
    const h = canvas.height

    let blank = document.createElement('canvas')
    blank.width = w
    blank.height = h
    if (canvas.toDataURL() === blank.toDataURL()) {
        console.log('没有要转换图片')
        return
    }
    const data = canvas.getContext('2d').getImageData(0, 0, w, h).data
    const colorNames = new Map()
    const colorStrs = [
        'bg {',
    ]
    let pos = 0,
        pPos = -4,
        px = 0
    for (let i = 0; i < h; i++) {
        pos += 4
        pPos += 4
        px = 0
        for (let j = 1; j < w; j++) {
            const pRgba = `${data[pPos++]} ${data[pPos++]} ${data[pPos++]} ${data[pPos++]}`
            const rgba = `${data[pos++]} ${data[pos++]} ${data[pos++]} ${data[pos++]}`
            if (pRgba !== rgba || j === w - 1) {
                if (!colorNames.has(rgba)) {
                    colorNames.set(rgba, 'color' + (10000 + colorNames.size))
                }
                const name = colorNames.get(rgba)
                const xp = 12, yp = 7
                colorStrs.push(pix2code(pos, px + xp, i + yp, j + xp, i + 1 + yp, name))
                px = j
            }
        }
    }
    colorStrs.push('}')

    const tmpArray = [
        'colors {'
    ]
    colorNames.forEach((k, v) => {
        tmpArray.push(`\t${k} = "${v}"`)
    })
    tmpArray.push('}')
    const content = `${tmpArray.join('\r\n')}\r\n${colorStrs.join('\r\n')}`
    console.log(content)
    // saveFile(content, 'pic.styles')

    function randStr() {
        return (((1 + Math.random()) * 0x10000000) | 0).toString(16).substring(1)
    }

    function pix2code(index, x1, y1, x2, y2, color) {
        // let pixCodeArr = ['\t0="fill(x0+', '', ', y0+', '', ', x0+', '', ', y0+', '', ', ', '', ')"']
        let pixCodeArr = ['\t', '', '="fill(x0+', '', ', y0+', '', ', x0+', '', ', y0+', '', ', ', '', ')"']
        pixCodeArr[1] = index
        pixCodeArr[3] = x1
        pixCodeArr[5] = y1
        pixCodeArr[7] = x2
        pixCodeArr[9] = y2
        pixCodeArr[11] = color
        return pixCodeArr.join('')
    }
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
