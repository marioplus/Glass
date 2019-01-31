# 前言

2019/1/31

> 继续填之前的坑，这次带来纯色背景，详细信息在后面。

2018/8/8

>这个更新主要完成了配色的简单切换，然后就是调整了一些细节，不少同学反映找不到好友按钮。那我就重新把它调整出来好了。

>这个配色更新，个人觉得比较重要应该会单独开一个帖子详细讲解一下。

>怪猎快要解锁了，这几天好好干，之后估计就要摸一段时间的鱼了。下次更新指不定什么时候。

2018/7/26

>很幸运找到了拓展游戏列表视图的列表的方法，但是很遗憾还不过完美。

2018/7/25

>距离上次更新已经快3个月了，这个三个月我离开了工作一年半的公司，新工作换了个方向（当然依旧是最底层的码农），现在基本是稳定了。不过新公司加班很严重，没太多时间做自己喜欢的事儿。测试版除了，我就开始新版本的适配，以及继续做之前没做好的部分。不过进度堪忧啊。

>现在还是有些后悔，之前的那个版本根本就残疾，应该做的好些再放出来的。不过既然放出来了，就一定要把它做好（~~其实我是想完成度高些再放出来的，不过今天关于皮肤的帖子多的有点渗人~~），比起无人深坑，我这才那啊。

>如果你有好的想♂法，或者皮♂肤制作的同♂道中人，欢迎联系我（微笑.png）。

2018/5/4

>我是一个程序员，更是一个游戏爱好者。

>每次接触到一个新游戏（特指单机）时，如果这个游戏和我的胃口，我总会到网上找到一些和这个游戏相关的资源，比如mod和ce之类的东西。

>突然有一天我有了这样的想法，做出这些东西的人应该是程序员吧。我为什么不能向他们一样做出一点自己的东西？好吧自己太菜了做不出来（~~此处脑补滑稽的表情~~）。

>直到后来，我发现steam的皮肤可以通过修改配置文件来修改其界面，这一次轮到我来给大家做点什么吧。


# 这是什么
这是一个自制的steam皮肤，由于有很多玻璃效果，我叫它 **Glass**。

# 看看效果

## 清晰背景

![PtIALd.png](https://s1.ax1x.com/2018/07/26/PtIALd.png)

![PtIeot.png](https://s1.ax1x.com/2018/07/26/PtIeot.png)

![PtIZdI.png](https://s1.ax1x.com/2018/07/26/PtIZdI.png)

![PtIVeA.png](https://s1.ax1x.com/2018/07/26/PtIVeA.png)

## 模糊背景

![PtIlQg.png](https://s1.ax1x.com/2018/07/26/PtIlQg.png)

![PtI3Lj.png](https://s1.ax1x.com/2018/07/26/PtI3Lj.png)

![PtI1yQ.png](https://s1.ax1x.com/2018/07/26/PtI1yQ.png)

![PtIQSS.png](https://s1.ax1x.com/2018/07/26/PtIQSS.png)

# 其他背景

![PtIksH.jpg](https://s1.ax1x.com/2018/07/26/PtIksH.jpg)


# 怎么使用

## 下载

[百度云](https://pan.baidu.com/s/1sXhuhxFlizooPmIossN6dQ) 密码:3nzw

[onedrive](https://1drv.ms/f/s!AlLFfmBi5_NSlM8ylMVrHnPO4qGcow)

## 安装

解压 **Glass.zip**，解压后的文件夹丢到你的steam皮肤文件夹中，路径大概是这样的**x:\steam\skin\**。完成后他看起来应该是这样的:**x:\steam\skin\Glass**。

安装 **Glass\resource\fonts** 文件夹中的 **iomanoid.ttf** 和 **Microsoft YaHei Mono.ttf** 两个字体。

启动你的steam，在设置中更换皮肤为Glass。

什么？你不知道怎么换皮肤？如果我是你的话，我会在 **设置**-**界面** 中好好看看。

## 如何更换背景
我自己做了好几张背景吧，想更换其他的背景，只需要将 **Glass\graphics\bg\\** 中任意一个 **tga** 文件改为 **bg.tga** 即可，与 **tga** 文件同名的 **png** 文件是预览图。

不过我不建议直接改名，在改名之前应该先复制一张。

## 更换纯色背景
[点击查看纯色更新详情](https://steamcn.com/t462150-1-1)

## 我想拥有自己专属的背景
不满意我做的背景？那就只有自己动手了。背景图的大小应该根据自己的电脑屏幕分辨率决定。我的电脑是1920x1080，所以全部的预设背景图全是这个分辨率。

1. 找到自己心爱的图片后。
2. 你需要在ps中打开这张图片。
3. **滤镜**-**模糊**-**高斯模糊**，调整模糊程度（不需要模糊可略过模糊），直到自己满意。推荐15~25.
4. 然后保存为 **tga** 格式！然后保存为 **tga** 格式！然后保存为 **tga** 格式！
5. 之后替换 **Glass\graphics\bg\bg.tga** 就ok了。

+ 注意：各位大哥，直接改文件后缀，是改不了文件格式的哦（~~滑稽.png~~）。

## 如何更换配色

[点击查看预置配色详情](https://steamcn.com/t413413-1-1)

1. 打开 **Glass\includes\colors.styles**，你会看到很多以 **include** 开头的语句。
2. 选择一个喜欢的配色，然后将其他的 **include** 前面加上 **//** 注释点。
3. 重启steam即可看到效果。

+ 注意： **此文件中只能有一条 include 前面没有 //。**

## 自定义配色

对我的配色不满意？为什么不试着自己动手！

1. 打开 **Glass\includes\colors.styles**，你会看到很多以 **include** 开头的语句。
2. 打开 **include "includes/colors/custom_color.styles"** 的注释，并且确保在其他的 **include** 语句前面有 **//**。
3. 打开 **Glass\includes\colors\custom_color.styles**。
4. 修改第18行-第25行的几个颜色定义。
    1. 每一个颜色通过这种方式定义： **颜色名称="R ,G ,B, A"** ，请注意，所有符号都应该是英文符号。
    2. 颜色可以被继承，就像下面这样： **yourCustomColor2=light-blue-300**。
    3. 如果你有仔细观察，就会发现，我所有使用的颜色都被定义在  **Glass\includes\colors\matelial_colors.styles** 中。
    4. 如果你不想自己定义颜色，你可以使用我定义的颜色，具体颜色是什么样子的，你可以在 **Glass\includes\colors\material color.png** 中查看
    5. 定义你自己的颜色时，颜色名称最好就上一个 your 以免其他地方已经有这个颜色的定义了。
    6. 如果你定义配色后，没有效果，或者steam上的文字全部消失。请看看控制台的日志。


# 目前已知问题
+ ~~随处可见的开始按钮~~
+ 游戏卡片视图的启动按钮，暂时没有找到水平垂直居中的方案，只能自己调整卡片大小
+ 游戏列表性情列表头的分割线无法控制，位置很奇怪
+ 游戏列表性情列表头的分类选项被挤出渲染区域，暂时无解
+ 下载页面，当前正在下载项的 **查看新闻** 和 **已启用自动更新** 无法使用。暂时未找到然他们渲染在最上层的方式，

# 更新计划
+ ~~处理下载页面~~
+ ~~处理控制台页面~~
+ ~~处理卡片视图页面~~
+ ~~整合菜单steam、好友、视图、游戏、帮助为一个菜单，菜单使用steam logo代替文字~~
+ ~~处理好友列表（暂时没找到手段动手）~~
+ ~~处理聊天面板（暂时没找到手段动手）~~
+ 处理游戏中显示页面
+ ~~添加一套背景配色，以取代玻璃效果~~
+ 撰写快速调整配色的教程
+ 撰写详细的steam皮肤制作教程
    1. 如何快速重启steam客户端
    2. 如何快速定位要修改文件
    3. steam皮肤配置文件结构梳理
    4. 可使用的control配置属性
    5. 可使用的style配置属性
    6. 可使用的place/region配置属性
    7. 如何制作出圆角和阴影效果
    8. 小技♂巧

# 目前进度

+ 20191/31
    + 调整了控制玻璃效果的阴影
    + 重新制作了菜单按钮图标，原先的按钮图标在浅色背景下表现效果不佳
    + 新增了纯色方式背景，干脆就叫纯色更新好了

+ 2018/8/8
    + 统一调整配色，并配置17套配色，以及一个用于自定义配色的文件，现在只需要简单的注释代码就可以更换配色
    + 调整游戏详情视图左边的游戏列表的列表项之间的间距，看起来更舒服
    + 游戏列表中的游戏名称鼠标悬浮时，添加一个颜色，看起来更直观
    + 选择游戏后，该游戏在游戏列表中和其他游戏有不同颜色的区分
    + 游戏详情页的游戏名（最大的那个游戏名称）颜色改为主题色
    + 将好友图标重新调整出来，并制作新的图标

+ 2018/7/26
    + 整合菜单steam、好友、视图、游戏、帮助为一个菜单，菜单使用steam logo代替文字
    + 调整列表视图的样式，好看的不少，不过列表头上的分割线去不掉很烦。
    + 将制作背景的原素材也放进来了。
        
+ 2018/7/25
    + 处理下载页面
    + 处理控制台页面
    + 调整所有游戏展示页面，让左侧的菜单按钮显示出来，不过列表视图依然丑爆

# 彩蛋
这套皮肤中其实有一个彩蛋的，就是不知道大家找不找得到了（~~此处脑滑稽计表情~~）。

# FQA
1. 更换完皮肤steam打不开，或者打开卡死。

> 点开解压的 **Glass** 文件夹，看看里面是不是还有一个 **Glass**。这是解压的时候带了一个文件夹，请确保点开 **Glass**，出现的是 **graphics**、**resource** 和 **README.md**。

2. 我想使用效果图中的清晰背景，怎么办？

>请使用上文中提到的更换背景的方法更换，效果途中的防火女背景大概在这个位置： **Glass\graphics\bg\fire keeper 2.tga**

3. 为什么其他皮肤这么大？

>首先我的皮肤使用2个字体文件，一起14.3M,其次我提供的背景很多，还包括原图，有的原图甚至是4K的，这些背景共114M（微笑.png）。

4. 如果皮肤出现问题，且steam界面上什么没有。可以在 **Steam\skins\** 中删除皮肤文件，重启steam后，steam会加载默认皮肤。
