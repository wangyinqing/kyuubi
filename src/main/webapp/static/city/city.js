(function (cityAll) {
    var jck = {};
    jck.base = {
        /* 选择元素 */
        $: function (arg, context) {
            var tagAll, n, eles = [], i, sub = arg.substring(1);
            context = context || document;
            if (typeof arg == 'string') {
                switch (arg.charAt(0)) {
                    case '#':
                        return document.getElementById(sub);
                        break;
                    case '.':
                        if (context.getElementsByClassName) return context.getElementsByClassName(sub);
                        tagAll = Vcity.static.$('*', context);
                        n = tagAll.length;
                        for (i = 0; i < n; i++) {
                            if (tagAll[i].className.indexOf(sub) > -1) eles.push(tagAll[i]);
                        }
                        return eles;
                        break;
                    default:
                        return context.getElementsByTagName(arg);
                        break;
                }
            }
        },
        /* 绑定事件 */
        on: function (node, type, handler) {
            node.addEventListener ? node.addEventListener(type, handler, false) : node.attachEvent('on' + type, handler);
        },

        /* 获取事件 */
        getEvent: function (event) {
            return event || window.event;
        },

        /* 获取事件目标 */
        getTarget: function (event) {
            return event.target || event.srcElement;
        },

        /* 获取元素位置 */
        getPos: function (node) {
            var scrollx = document.documentElement.scrollLeft || document.body.scrollLeft,
                scrollt = document.documentElement.scrollTop || document.body.scrollTop;
            var pos = node.getBoundingClientRect();
            var w = node.clientWidth, h = node.clientHeight;
            if (node.getAttribute('data_position') == "fixed") {
                return {
                    top: pos.top,
                    right: pos.right,
                    bottom: pos.bottom,
                    left: pos.left,
                    width: w,
                    height: h
                }
            }
            return {
                top: pos.top + scrollt,
                right: pos.right + scrollx,
                bottom: pos.bottom + scrollt,
                left: pos.left + scrollx,
                width: w,
                height: h
            };
        },

        /* 添加样式名 */
        addClass: function (c, node) {
            if (!node)return;
            node.className = jck.base.hasClass(c, node) ? node.className : node.className + ' ' + c;
        },

        /* 移除样式名 */
        removeClass: function (c, node) {
            var reg = new RegExp("(^|\\s+)" + c + "(\\s+|$)", "g");
            if (!jck.base.hasClass(c, node))return;
            node.className = reg.test(node.className) ? node.className.replace(reg, '') : node.className;
        },

        /* 是否含有CLASS */
        hasClass: function (c, node) {
            if (!node || !node.className)return false;
            return node.className.indexOf(c) > -1;
        },

        /* 阻止冒泡 */
        stopPropagation: function (event) {
            event = event || window.event;
            event.stopPropagation ? event.stopPropagation() : event.cancelBubble = true;
        },
        /* 去除两端空格 */
        trim: function (str) {
            return str.replace(/^\s+|\s+$/g, '');
        },
        getPostion: function (node) {
            var scrollx = document.documentElement.scrollLeft || document.body.scrollLeft,
                scrollt = document.documentElement.scrollTop || document.body.scrollTop;
            var pos = node.getBoundingClientRect();
            var w = node.clientWidth, h = node.clientHeight;
            return {
                top: parseInt(node.getAttribute('datatop')) || pos.top + scrollt,
                right: pos.right + scrollx,
                bottom: parseInt(node.getAttribute('databottom')) || pos.bottom + scrollt,
                left: pos.left + scrollx,
                width: w,
                height: h
            };
        },
        debug: function (str) {
            var t = this;
            if (t.constructor.config.debug) {
                console.log(str)
            }
        }
    }
    jck.cityAsy = {
        /* *
         * @getCityChild
         * 获取child
         * */
        getCityChild: function (code, tabName) {
            //不同的tabName所对比的code位置不同；
            var tabs = {
                hotChild: 5, proChild: 4, cityChild: 5, countyChild: 6
            }, arr = [], index = tabs[tabName];
            for (var i in jck.allCity) {
                var a = jck.allCity[i];
                if (a[index] == code) {
                    arr.push(a);
                }
            }
            return arr;
        },
        /* *
         * @combinationCity
         * 重新组合数据
         * */
        combinationCity: function (arr, tabName) {
            var tabs = {
                hotChild: 5,
                proChild: 4,
                cityChild: 5,
                countyChild: 6
            }, index = tabs[tabName] + 1, reArr = [], reChong = {};
            for (var i in arr) {
                var a = arr[i];
                if (reChong[a[index]])continue;
                reChong[a[index]] = a[index - 3]
                reArr.push({
                    code: a[index],
                    name: a[index - 3]
                });
            }
            return reArr;
        },
        /* *
         * @dynamicCreateChild
         * 动态生成城市/县区数据集合并展示
         * */
        dynamicCreateChild: function (child, ele) {
            var t = this, index = ele;
            var odl, odt, odd, odda = [];
            odl = document.createElement('dl');
            odt = document.createElement('dt');
            odd = document.createElement('dd');
            odt.innerHTML = '&nbsp';
            for (var i in child) {
                odda.push('<a city-code="' + child[i].code + '" >' + child[i].name + '</a>')
            }
            odd.innerHTML = odda.join('');
            odl.appendChild(odt);
            odl.appendChild(odd);
            ele.innerHTML = "";
            ele.appendChild(odl);
        },
    }
    jck.allCity = cityAll;
    jck.cityTemplate = [
        '<p class="cityTip">直接输入可搜索城市名(支持汉字/英文)</p>',
        '<ul>',
        '<li class="on">热门城市</li>',
        '<li>省份</li>',
        '<li>城市</li>',
        '<li>区县</li>',
        '</ul>'
    ];
    jck.cityHot = "深圳,广州,上海".split(',');
    //初始化基本数据  hotChild:hot,proChild:pro,cityChild:null,countyChild:null
    jck.tabChild = (function () {
        var hot = jck.cityHot, allCity = jck.allCity, pro = [];
        for (var i in hot) {
            var h = hot[i];
            for (var j in allCity) {
                var city = allCity[j];
                if (city[2] === h) {
                    h = {};
                    h[city[5]] = city[2];
                    h = {
                        code: city[5],
                        name: city[2]
                    };
                    break;
                }
            }
            hot[i] = h;
        }
        var fl = {};
        for (var j in allCity) {
            var all = allCity[j];
            var p = {};
            if (fl[all[4]]) {
                continue;
            }
            fl[all[4]] = all[1];
            pro.push({
                code: all[4],
                name: all[1]
            })
        }
        ;
        //给省份按拼音排序
        // pro.sort(function (a, b) {
        //     return (a.name).localeCompare(b.name);
        // });
        //北京排第一
        // var ad = pro[0];
        // pro[0] = pro[1];
        // pro[1] = ad;
        return {
            hotChild: hot,
            proChild: pro,
            cityChild: null,
            countyChild: null
        };
    })();
    jck.citySelector = function () {
        this.init.apply(this, arguments);
    }
    jck.citySelector.prototype = {
        constructor: jck.citySelector,
        /* *
         * @init
         * 初始化程序
         * */
        init: function (options) {
            var input = options.input, t = this;
            t.input = jck.base.$('#' + input);
            if (!t.input) {
                console.log('No find document "' + input + '"');
                return;
            }
            t.input.autocomplete = 'off';//关闭自动提示
            t.options = options;
            t.createWarp();
            t.inputEvent();
        },
        /* *
         * @inputEvent
         * 初始化输入框事件
         * */
        inputEvent: function () {
            var t = this;
            jck.base.on(t.input, 'focus', function (event) {
                var event = event || window.event;
                var value = this.value;
                t.hideBox();
                if (!t.cityBox) {//是否创建city容器
                    t.createWarp();//进行创建
                } else {
                    var div = t.rootDiv;
                    var inputPos = jck.base.getPos(this);
                    jck.base.removeClass('hide', t.cityBox);
                    div.style.left = inputPos.left + 'px';
                    div.style.top = inputPos.bottom - 1 + 'px';
                    div.style.zIndex = 999999;
                    jck.base.removeClass('hide', t.myIframe);
                    t.changeIframe();
                }
                //处理初始化赋值
                var sel = t.selArr = t.selArr || [];
                if (!!value && sel.length == 0) {
                    var vArr = value.split(',');
                    sel = sel || [];
                    for (var y = 0; y < vArr.length; y++) {
                        var str = vArr[y];
                        for (var a = 0; a < jck.allCity.length; a++) {
                            var all = jck.allCity[a];
                            if (all[y + 1] == str) {
                                sel.push({
                                    code: all[y + 4],
                                    name: all[y + 1]
                                });
                                break;
                            }
                        }
                        //处理检索为0的数据
                        if (!sel[y]) {
                            break;
                        }
                    }
                }
                t.writeInput();
                this.select();
            });
            jck.base.on(t.input, 'blur', function (event) {//失去焦点
                t.selArr = t.selArr || [];
                //当存在本地检索时候，情况本地检索内容
                if (!jck.base.hasClass('hide', t.ul) && !!t.ul) {
                    // jck.base.addClass('hide', t.ul);
                    // t.ul.innerHTML = "";
                    return;
                }
                if (t.selArr.length < 3) {
                    t.input.value = '';
                    return false;
                }
                t.writeInput();
            });
            jck.base.on(t.input, 'keyup', function (event) {//输入本地检索
                var event = event || window.event;
                var keycode = event.keyCode || event.which || event.charCode;
                jck.base.addClass('hide', t.cityBox);
                t.createUl();
                /* 移除iframe 的hide 样式 */
                jck.base.removeClass('hide', t.myIframe);
                // 下拉菜单显示的时候捕捉按键事件
                var lis = jck.base.$('li', t.ul);
                //特定键盘事件，上、下、Enter键
                if (t.ul && !jck.base.hasClass('hide', t.ul) && (!!lis[0] && !jck.base.hasClass('empty', lis[0]))) {
                    t.KeyboardEvent(event, keycode)
                }
            })
        },
        /* *
         * @createWarp
         * 创建城市BOX HTML框架
         * this.rootDiv:主要容器
         * this.cityBox:嵌套内部城市容器
         * this.cityList:用于存放各个类别的数据
         * */
        createWarp: function () {
            var t = this,
                inputPos = jck.base.getPos(t.input),
                div = t.rootDiv = document.createElement('div');
            //阻止冒泡
            jck.base.on(t.rootDiv, 'click', function (event) {
                jck.base.stopPropagation(event);
            });
            // 设置点击文档隐藏弹出的城市选择框
            jck.base.on(document, 'click', function (event) {
                event = jck.base.getEvent(event);
                var target = jck.base.getTarget(event);
                if (target == t.input)return false;
                t.hideBox();
            });
            div.className = 'citySelector' + ' city' + (jck.base.$('.citySelector').length + 1);
            div.style.position = t.input.getAttribute('data_position') || 'absolute';
            div.style.left = inputPos.left + 'px';
            div.style.top = inputPos.bottom - 1 + 'px';
            div.style.zIndex = 999999;
            t.createIe6Iframe();
            //生成热门城市Warp
            var cityBox = t.cityBox = document.createElement('div');
            cityBox.className = 'cityBox' + ' cityBox' + (jck.base.$('.citySelector').length + 1);
            //加入city Tab容器
            cityBox.innerHTML = jck.cityTemplate.join('');
            var cityList = t.cityList = document.createElement('div');
            //生成省份数据Warp
            cityList.className = 'cityList' + ' cityList' + (jck.base.$('.citySelector').length + 1);
            cityBox.appendChild(cityList);
            div.appendChild(cityBox);
            //生成详细初始化数据展示信息
            t.createChild();
            t.hideBox();
        },
        /* *
         * @createChild
         * TAB下面的div:hotChild,proChild,cityChild,countyChild
         * 生成初始化数据信息展示
         **/
        createChild: function () {
            var t = this, tabChild = jck.tabChild;
            var odiv, odl, odt, odd, odda = [], str, key, index = 0;
            for (key in tabChild) {
                odiv = t[key] = document.createElement('div');
                odiv.tabName = key;
                odiv.index = index++;
                //    先设置全部隐藏
                odiv.className = key + ' cityTab' + ' cityTab' + (jck.base.$('.citySelector').length + 1) + ' hide';
                odda = [];
                odl = document.createElement('dl');
                odt = document.createElement('dt');
                odd = document.createElement('dd');
                odt.innerHTML = '&nbsp';
                if (!tabChild[key]) {
                    if (key == 'cityChild') {
                        str = '<b style="color:red;">请选择省份</b>';
                    }
                    if (key == 'countyChild') {
                        str = '<b style="color:red;">请选择城市</b>';
                    }
                    odda.push(str);
                } else {
                    for (var i in tabChild[key]) {
                        var city = tabChild[key][i];
                        str = '<a city-code="' + city.code + '" >' + city.name + '</a>';
                        odda.push(str);
                    }
                }
                odd.innerHTML = odda.join('');
                odl.appendChild(odt);
                odl.appendChild(odd);
                odiv.appendChild(odl);
                this.cityList.appendChild(odiv);
            }
            jck.base.removeClass('hide', t.hotChild);
            document.body.appendChild(this.rootDiv);

            //IE6
            t.changeIframe();
            t.tabChange();
            t.cityLinkEvent();
        },

        /* *
         *  @ tabChange
         * tab 改变触发事件
         * */
        tabChange: function () {
            var t = this;
            var lis = jck.base.$('li', t.cityBox),
                divs = jck.base.$('div', t.cityList);
            var child = ['hotChild', 'proChild', 'cityChild', 'countyChild'];
            for (var i in lis) {
                lis[i].tabName = child[i];
                lis[i].index = i;
                lis[i].onclick = function () {
                    for (var j = 0; j < lis.length; j++) {
                        jck.base.removeClass('on', lis[j]);
                        jck.base.addClass('hide', divs[j]);
                    }
                    var _this = this;
                    jck.base.addClass('on', this);
                    jck.base.removeClass('hide', divs[_this.index]);
                    /* IE6 改变TAB的时候 改变Iframe 大小*/
                    t.changeIframe();
                }
            }
        },
        /* *
         * @cityLinkEvent
         * 选择城市选择事件。
         * 分别触发不同hotChild,proChild,cityChild,countyChild产生的不同事件
         * */
        cityLinkEvent: function () {
            var t = this,
                links = jck.base.$('a', t.cityList);
            for (var i in links) {
                var link = links[i];
                if (link.onclick) {
                    continue;
                }
                //单击城市
                link.onclick = function () {
                    var _this = this;
                    var box = _this.parentNode.parentNode.parentNode,
                        code = _this.getAttribute('city-code'),
                        tabName = box.tabName, index = box.index, idx;
                    var child = jck.cityAsy.getCityChild(code, tabName);
                    t.selCity = child[0];
                    var lis = jck.base.$('li', t.cityBox),
                        divs = jck.base.$('div', t.cityList);
                    t.selArr = [];
                    if (child.length == 1) {//只有一个集合的时候执行回掉
                        if (tabName != 'countyChild') {//处理特殊异常的单挑数据
                            var cd = jck.cityAsy.getCityChild(t.selCity[4], 'proChild');
                            cd = jck.cityAsy.combinationCity(cd, 'proChild');
                            jck.cityAsy.dynamicCreateChild(cd, divs[2]);
                            lis[lis.length - 1].onclick();
                            cd = jck.cityAsy.getCityChild(t.selCity[5], 'cityChild');
                            cd = jck.cityAsy.combinationCity(cd, 'cityChild');
                            jck.cityAsy.dynamicCreateChild(cd, divs[divs.length - 1]);
                        }
                        t.selArr.push({code: t.selCity[4], name: t.selCity[1]});
                        t.selArr.push({code: t.selCity[5], name: t.selCity[2]});
                        t.selArr.push({code: t.selCity[6], name: t.selCity[3]});
                        t.cityLinkEvent();
                        t.hideBox();
                    } else {
                        var ide = jck.cityAsy.combinationCity(child, tabName);
                        if (tabName.indexOf('hotChild') > -1) {//热门城市
                            var cd = jck.cityAsy.getCityChild(t.selCity[4], 'proChild');
                            cd = jck.cityAsy.combinationCity(cd, 'proChild');
                            jck.cityAsy.dynamicCreateChild(cd, divs[2]);
                            lis[lis.length - 1].onclick();
                            cd = jck.cityAsy.getCityChild(t.selCity[5], 'cityChild');
                            cd = jck.cityAsy.combinationCity(cd, 'cityChild');
                            jck.cityAsy.dynamicCreateChild(cd, divs[divs.length - 1]);
                            idx = lis.length - 2;
                            t.selArr.push({code: t.selCity[4], name: t.selCity[1]});
                            t.selArr.push({code: t.selCity[5], name: t.selCity[2]});
                        } else {//正常选择流程
                            lis[(index + 1)].onclick();
                            //给数据进行按照拼音排序
                            // ide.sort(function (a, b) {
                            //     return (a.name).localeCompare(b.name);
                            // });
                            jck.cityAsy.dynamicCreateChild(ide, divs[(index + 1)]);
                            if (lis.length - 1 != (index + 1)) {
                                divs[divs.length - 1].innerHTML = '<b style="color:red;">请选择城市</b>'
                            }
                            if (index == 2) {
                                t.selArr.push({code: t.selCity[4], name: t.selCity[1]});
                                t.selArr.push({code: t.selCity[5], name: t.selCity[2]});
                            } else if (index == 1) {
                                if (ide.length == 1) {//处理单个城市，直接跳转至县区
                                    lis[lis.length - 1].onclick();
                                    var cd = jck.cityAsy.getCityChild(t.selCity[5], 'cityChild');
                                    cd = jck.cityAsy.combinationCity(cd, 'cityChild');
                                    jck.cityAsy.dynamicCreateChild(cd, divs[divs.length - 1]);
                                    t.selArr.push({code: t.selCity[4], name: t.selCity[1]});
                                    t.selArr.push({code: t.selCity[5], name: t.selCity[2]});
                                } else {
                                    t.selArr.push({code: t.selCity[4], name: t.selCity[1]});
                                }
                            }
                        }
                        t.cityLinkEvent();
                        // t.writeInput();
                    }
                    t.callback();
                }
            }
            ;
        },
        /* *
         * @callback()
         * 成功回掉方法
         * */
        callback: function () {
            var t = this, sel = t.selCity;
            t.writeInput();
            if (!t.options.callback) {
                console.log('选择成功');
                return false;
            }
            var hd_city = [];
            for (var di in t.selArr) {
                hd_city.push({
                    areaName: t.selArr[di].name,
                    areaCode: t.selArr[di].code
                })
            }
            t.options.callback(hd_city, t.cityBox, t.input);

        },
        /* *
         * @ createUl
         * 本地输入检索
         * */
        createUl: function () {
            var t = this, str, value = jck.base.trim(t.input.value);
            //记录按键次数，方向键
            if (value == '') {
                t.ul = t.ul || '';
                jck.base.addClass('hide', t.ul);
                t.ul.innerHTML = '';
                t.hideBox();
                t.ul.innerHTML = 0;
                jck.base.removeClass('hide', t.cityBox);
                jck.base.removeClass('hide', t.myIframe);
                return false;
            }
            var search = [];
            for (var i in jck.allCity) {
                var all = jck.allCity[i];
                if (all[7].toLowerCase().indexOf(value.toLowerCase()) == -1)continue;
                var li = document.createElement('li');
                li.setAttribute('data-code', all[4] + ',' + all[5] + ',' + all[6]);
                li.setAttribute('data-name', all[0]);
                li.innerHTML = '<b class="Vcityname">' + all[0] + '</b><b  class="Vcityspell"></b>';
                li.index = i;
                search.push(li.outerHTML)
            }
            if (search.length == 0) {
                str = '<li class="empty">对不起，没有找到 "<em>' + value + '</em>"</li>';
                var li = document.createElement('li');
                li.className = 'empty';
                li.innerHTML = '对不起，没有找到 <em style="font-size: 14px;color: red;">' + value + '</em>';
                search.push(li.outerHTML);
            }
            if (!t.ul) {
                this.count = 0;
                var ul = t.ul = document.createElement('ul');
                ul.className = 'cityslide mCustomScrollbar';
                t.rootDiv && t.rootDiv.appendChild(ul);
            } else if (t.ul && jck.base.hasClass('hide', t.ul)) {
                this.count = 0;
                jck.base.removeClass('hide', t.ul);
            }
            //ul 宽度设置
            t.ul.style.width = ((t.input.clientWidth >= 180 && t.input.clientWidth <= 300) ? t.input.clientWidth : 220) + 'px'
            t.ul.innerHTML = search.join('');
            /* IE6 */
            this.changeIframe();
            // 绑定Li事件
            this.liEvent();
        },
        /* *
         * @liEvent
         * 本地检索后，每一行数据的单击事件
         * */
        liEvent: function () {
            var t = this;
            var lis = jck.base.$('li', t.ul);
            for (var i = 0; i < lis.length; i++) {
                jck.base.on(lis[i], 'click', function (event) {
                    event = event || window.event;

                    var codes = this.getAttribute('data-code').split(',');
                    var names = this.getAttribute('data-name').split(',');
                    t.selArr = [];
                    for (var c = 0; c < 3; c++) {
                        t.selArr.push({
                            code: codes[c],
                            name: names[c]
                        })
                    }
                    ;
                    t.callback();
                    t.hideBox();
                    //当存在本地检索时候，情况本地检索内容
                    if (!jck.base.hasClass('hide', t.ul) && !!t.ul) {
                        jck.base.addClass('hide', t.ul);
                        t.ul.innerHTML = "";
                    }
                })
            }
        },
        /* *
         * @KeyboardEvent
         * 特定键盘事件，上、下、Enter键
         * */
        KeyboardEvent: function (event, keyCode) {
            var t = this;
            var lis = jck.base.$('li', t.ul);
            var len = lis.length;
            switch (keyCode) {
                case 40://箭头向下
                    t.count++;
                    if (t.count > len - 1)t.count = 0;
                    for (var i = 0; i < len; i++) {
                        jck.base.removeClass('on', lis[i]);
                    }
                    jck.base.addClass('on', lis[t.count]);
                    break;
                case 38://箭头向上
                    t.count--;
                    if (t.count < 0)t.count = len - 1;
                    for (var i = 0; i < len; i++) {
                        jck.base.removeClass('on', lis[i]);
                    }
                    jck.base.addClass('on', lis[t.count])
                    break;
                case 13://Enter键
                    var li = lis[t.count],
                        names = li.getAttribute('data-name'),
                        codes = li.getAttribute('data-code');
                    names = names.split(',');
                    codes = codes.split(',');
                    t.selArr = [];
                    for (var i = 0; i < names.length; i++) {
                        t.selArr.push({
                            code: codes[i],
                            name: names[i]
                        })
                    }
                    t.hideBox();
                    t.callback();
                    break;
                default:
                    break
            }
        },
        /* *
         * @isIe6
         * 判断是否IE6，如果是IE6需要添加iframe才能遮住SELECT框
         * */
        createIe6Iframe: function () {
            var t = this;
            var isIe = (document.all) ? true : false;
            var isIE6 = this.isIE6 = isIe && !window.XMLHttpRequest;
            if (isIE6) {
                var myIframe = t.myIframe = document.createElement('iframe');
                myIframe.frameborder = '0';
                myIframe.src = 'about:blank';
                myIframe.style.position = 'absolute';
                myIframe.style.zIndex = '-1';
                t.rootDiv.appendChild(t.myIframe);
            }
        },
        /* *
         * @changeIframe
         * IE6的改变遮罩SELECT 的 IFRAME尺寸大小
         * */
        changeIframe: function () {
            if (!this.isIE6)return;
            this.myIframe.style.width = this.rootDiv.offsetWidth + 'px';
            this.myIframe.style.height = this.rootDiv.offsetHeight + 'px';
        },
        /* *
         * @writeInput
         * 给文本框赋值
         * */
        writeInput: function () {
            var t = this, str = [];
            for (var i in t.selArr) {
                str.push(t.selArr[i].name);
            }
            t.input.value = str.join(',');
        },
        hideBox: function () {
            var t = this;
            if (t.cityBox)jck.base.addClass('hide', t.cityBox);
            if (t.ul) {
                jck.base.addClass('hide', t.ul);
                t.ul.innerHTML = ''
            }
            if (t.myIframe)jck.base.addClass('hide', t.myIframe);
            if (!!t.selArr && t.selArr.length < 3)t.input.value = '';
            if (t.options.hideBoxEvent) {
                t.options.hideBoxEvent(t.cityBox, t.input);
            }
        }
    }
    window.Vcity = window.Vcity || {};
    window.Vcity.CitySelector = window.Vcity.CitySelector || jck.citySelector;
})((function () {
    var respText;
    $.ajax({
        type: "GET",
        url: "/get/cityList",
        data: {},
        dataType: "json",
        async: false,
        cache: false,
        success: function (responseText) {
            var html = '';
            if (responseText) {
                respText = responseText;
            }

        },
        error: function (data) {
            alert(data);
        }
    });
    var cityAllStr2 = "";
    for (var i = 0; i < respText.length; i++) {
        for (j = 0; j < respText[i].children.length; j++) {
            for (k = 0; k < respText[i].children[j].children.length; k++) {
                cityAllStr2 = cityAllStr2 + respText[i].name + "," + respText[i].children[j].name + "," + respText[i].children[j].children[k].name + ","
                    + respText[i].id + "," + respText[i].children[j].id + "," + respText[i].children[j].children[k].id + ","
                    + respText[i].children[j].name + "@";
            }
        }
    }
    var cityAll = cityAllStr2.substring(0, cityAllStr2.length - 1).split('@');
    var arr = [];
    for (var i = 0; i < cityAll.length; i++) {
        var ca = cityAll[i].split(',');
        ca[0] = ca[0].replace(/[省|市]$/g, '');
        ca[1] = ca[1].replace(/市$/g, '');
        if (ca[0] == "台湾" || ca[0] == "香港" || ca[0] == "澳门") {
            continue;
        }
        arr.push([]);
        for (var j = 0; j < 7; j++) {
            arr[i].push(ca[j]);
        }
        arr[i].unshift(ca.splice(0, 3).join(','));
        // cityAll[i].unshift(ca.splice(0, 3).join(','));
    }
    return arr;
})());