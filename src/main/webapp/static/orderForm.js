!function ($) {
    $.fn.validation = function (options) {
        return this.each(function () {
            globalOptions = $.extend({}, $.fn.validation.defaults, options);
            validationForm(this);
        });
    };

    $.fn.validation.defaults = {
        onBefore: function () {
            return true;
        },
        validRules: [
            {
                name: 'required', validate: function (value) {
                return ($.trim(value) == '');
            }, defaultMsg: '不能为空'
            },
            {
                name: 'length', validate: function (value, param) {
                var p = param.split(",");
                return !((p.length == 2) ? ($.trim(value).length >= p[0] && $.trim(value).length <= p[1] ) : ( $.trim(value).length != param));
            }, defaultMsg: '长度不符'
            },
            {
                name: 'number', validate: function (value) {
                return (!/^[0-9]\d*$/.test(value));
            }, defaultMsg: '请输入数字。'
            },
            {
                name: 'decimal', validate: function (value) {
                return (!/^\d{1,18}(.\d{1,2})?$/gi.test(value));
            }, defaultMsg: '请输入货币'
            },
            {
                name: 'email', validate: function (value) {
                return (!/^[a-zA-Z0-9]{1}([\._a-zA-Z0-9-]+)(\.[_a-zA-Z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+){1,3}$/.test(value));
            }, defaultMsg: '请输入邮箱地址。'
            },
            {
                name: 'zip', validate: function (value) {
                return (!(/^[1-9][0-9]{5}$/.test(value) || /^.{4,15}$/.test(value)));
            }, defaultMsg: '请输入正确邮编'
            },
            {
                name: 'newzip', validate: function (value) {
                return (!(/^[\w\s\d\-\&\(\)]{2,15}$/.test(value)));
            }, defaultMsg: '请输入正确邮编'
            },
            {
                name: 'english', validate: function (value) {
                return (!/[\w\.()\,]+$/.test(value));
            }, defaultMsg: '请输入英文字符'
            },
            {
                name: 'noEnglishNum', validate: function (value) {
                return (!/[a-zA-Z]+$/.test(value));
            }, defaultMsg: '请输入英文字符'
            },
            {
                name: 'noEnglishNums', validate: function (value) {
                return (!/\w+[\w\s\%]+/.test(value));
            }, defaultMsg: '请输入英文字符'
            },
            {
                name: 'EnglishNum', validate: function (value) {
                return (!/^[A-Za-z\d][^\d\s\.\(\)\$%,-<>_#]([a-zA-Z\d\s\.\(\)\$%,-<>_#])+$/.test(value));
            }, defaultMsg: '请输入英文字符'
            },
            {
                name: 'char', validate: function (value) {
                return (!/^[a-zA-Z]*$/.test(value));
            }, defaultMsg: '请输入英文字符'
            },
            {
                name: 'qq', validate: function (value) {
                return (!/^[^0]\d{4,9}$/.test(value));
            }, defaultMsg: '请输入正确QQ'
            },
            {
                name: 'areacode', validate: function (value) {
                return (!/^0\d{2,3}$/.test(value));
            }, defaultMsg: '请输入正确区号'
            },
            {
                name: 'phonecode', validate: function (value) {
                return (!/\d{7,8}$/.test(value));
            }, defaultMsg: '请输入正确电话号码'
            },
            {
                name: 'telephone', validate: function (value) {
                return (!/^0\d{2,3}\-?\d{7,8}$/.test(value));
            }, defaultMsg: '请输入正确电话号码'
            },
            {
                name: 'phone', validate: function (value) {
                return (!/^((\(\d{2,3}\))|(\d{3}\-))?1(3|4|5|6|7|8)\d{9}$/.test(value));
            }, defaultMsg: '请输入正确手机号码'
            },
            {
                name: 'tele_phone', validate: function (value) {
                return !/^[0-9\-]{7,15}/ig.test(value);
            }, defaultMsg: '请输入正确电话号码'
            },
            {
                name: 'teleorphone', validate: function (value) {
                return (!(/^((\(\d{2,3}\))|(\d{2,3}\-?))(0\d{2,3}\-?)?\d{6,10}$/.test(value) || /^((\(\d{2,3}\))|(\d{2,3}\-?))?1(3|4|5|6|7|8|9)\d{9,19}$/.test(value)));
            }, defaultMsg: '请输入正确电话号码'
            },
            {
                name: 'password', validate: function (value) {
                return (!safePassword(value));
            }, defaultMsg: '密码由字母和数字组成，至少6位'
            },// check-type="password"
            {
                name: 'password_new', validate: function (value) {
                return (!/^[a-zA-Z\d]{6,20}$/.test(value));
            }, defaultMsg: '密码由字母和数字组成，至少6位'
            },// check-type="password"
            {
                name: 'phonetel', validate: function (value, param) {
                var d = $.trim(value), d1 = $.trim($(param).val());
                if (value != "") {
                    return !(/^[\d\s\(\)\-\&\-\+]{0,30}$/g.test(value))
                } else {
                    return !(/^[\d\s\(\)\-\&\-\+]{1,30}$/g.test($(param).val()));
                }
            }, defaultMsg: '手机与电话选填且输入正确字符'
            },//  check-type="phoneTel #sendMobile"   ,sendMobile需要比较的ID
            {
                name: 'rePassword', validate: function (value, param) {
                return (!($.trim(value).length > 0 && value == $(param).val()));
            }, defaultMsg: '与设置密码不一致'
            },//  check-type="rePassword #inputPassword"   ,inputPassword需要比较的ID
            {
                name: 'idcard', validate: function (value) {
                return (!idCard(value));
            }, defaultMsg: '身份证号码不正确'
            },
            {
                name: 'rex', validate: function (value, param) {
                return (!param.test(value));
            }, defaultMsg: '匹配失败'
            },
            {
                name: 'chinese', validate: function (value) {
                return (!/^[\u4E00-\u9FFF]+$/.test(value));
            }, defaultMsg: '请输入汉字'
            },
            {
                name: 'notchinese', validate: function (value) {
                return "" == value || (/^[\u4E00-\u9FFF]+$/.test(value));
            }, defaultMsg: '请输入英文'
            },
            {
                name: 'twoChinese', validate: function (value) {
                return (!twoChinese(value));
            }, defaultMsg: '请输入至少两个汉字'
            },
            {
                name: 'englishoREW', validate: function (value) {
                !(/^([\u0401-\u04e9_\s\w\.\(\),]+)$/.test(value));
            }, defaultMsg: '请输入正确的文字'
            },
            // {name: 'number60', validate: function(value) {return !((/^\d{1,18}(.\d{1,2})?$/gi.test(value)) && (value<=60 && value>0));}, defaultMsg: '最大值不能超过60'},
            {
                name: 'number2000', validate: function (value) {
                return !((/^\d{1,18}(.\d{1,2})?$/gi.test(value)) && (  value > 0));
            }, defaultMsg: '最大值不能超过2000'
            },
            //{name: 'nohtml', validate: function(value) {return !(/(<([^\s>]+)[^>]*>(.|\n)*?<\/([^\s>]+)>)|(<([^\s>]+)[^>]*\/>)|([^'"]*?)/gi.test(value));}, defaultMsg: '请输入正确的数据'},
            {
                name: 'nohtml', validate: function (value) {
                return (/(<([^\s>]+)[^>]*>)/gi.test(value));
            }, defaultMsg: '请输入正确的数据'
            },
            {
                name: 'englishoOrRussian',
                validate: function (value) {
                    if ((/^[\d\.\(\)\$\*%,-<>_'#]+$/.test(value) != true)) {
                        if ((/^[a-zA-Z\d\s\.\(\)\$\*%,-<>'_#]+$/.test(value))) {
                            return false;
                        } else if (/^[\u0401-\u04e9\s\d\.\(\)\*%,-_<>'_#]+$/.test(value)) {
                            return false;
                        } else {
                            return true;
                        }
                    } else {
                        return true;
                    }
                },
                defaultMsg: '请输入俄文或英文字符。'
            },
            {
                name: 'englishNew', validate: function (value) {
                return !(/^[\d\s\.\(\)\$\&\*%,-<>'_#]+$/.test(value) != true && /^[a-zA-Z\d\s\.\(\)\$\*\&%,-<>'_#]+$/.test(value) == true)
            }, defaultMsg: '请输入英文字符'
            },
            {
                name: 'english300', validate: function (value) {
                var ve = value.length;

                if (ve >= 1 && ve <= 300) {
                    return false;
                } else {
                    return true;
                }
                return !(/^.{1,300}$/.test(value))
            }, defaultMsg: '仅限输入300位字符'
            },
            {
                name: 'english50', validate: function (value) {
                return !(/^[\d\s\w\.\(\)\$\&\*%,-<>'_#]{1,50}$/.test(value))
            }, defaultMsg: '仅限输入50位非中文字符'
            },
            {
                name: 'noCh50', validate: function (value) {
                return !(/^[^\u4E00-\u9FFF]{1,50}$/.test(value))
            }, defaultMsg: '仅限输入50位非中文字符'
            },
            {
                name: 'warehouseCode',
                validate: function (value) {//仓库代码
                    return !(/^[^\u4E00-\u9FFF]{2,10}$/g.test(value));
                },
                defaultMsg: '不能为空ddd'
            },
            {
                name: 'lian1-2',
                validate: function (value) {
                    var re = $('[name="receiver.ctype"]:checked').val();
                    if (re == 2) {
                        return !(/^.{2,50}$/g.test(value));
                    } else {
                        return false;
                    }
                },
                defaultMsg: ''
            },
            {
                name: 'lian1-4',
                validate: function (value) {
                    var re = $('[name="receiver.ctype"]:checked').val();
                    if (re == 4) {
                        return !(/^.{2,10}$/g.test(value));
                    } else {
                        return false;
                    }
                },
                defaultMsg: '请输入2-10字符'
            },
            {
                name: 'lian2',
                validate: function (value) {
                    var re = $('[name="receiver.ctype"]:checked').val();
                    if (re == 2) {
                        return !(/^[\d\s\(\)\&\-]{2,20}$/g.test(value));
                    } else {
                        return false;
                    }
                },
                defaultMsg: '请输入20位内数字'
            },
            {
                name: 'lian3',
                validate: function (value) {
                    return !(/^.{0,50}$/g.test(value));
                },
                defaultMsg: '请输入50位非中文字符'
            },
            {
                name: 'lian3-1',
                validate: function (value) {
                    return !(/^.{2,50}$/g.test(value));
                },
                defaultMsg: '请输入1-50位非中文字符'
            },
            {
                name: 'lian4',
                validate: function (value) {
                    return !(/^.{2,30}$/g.test(value));
                },
                defaultMsg: '请输入1-30位非中文字符'
            },
            {
                name: 'lian5',
                validate: function (value) {
                    return !(/^.{2,10}$/g.test(value));
                },
                defaultMsg: '请输入1-10位非中文字符'
            },
            {
                name: 'lian50',
                validate: function (value) {
                    value = value || '';
                    return !(value.length > 0 && value.length <= 50);
                },
                defaultMsg: '请输入1-50位字符'
            },
            {
                name: 'lian6',
                validate: function (value) {
                    return !(/^[^\u4E00-\u9FFF]{2,300}$/g.test(value));
                },
                defaultMsg: '请输入1-100位非中文字符'
            },
            {
                name: 'warehouseCode',
                validate: function (value) {//仓库代码
                    return !(/^[^\u4E00-\u9FFF]{2,10}$/g.test(value));
                    return ($.trim(value) == '');
                },
                defaultMsg: '不能为空'
            },
            {
                name: 'notCN',
                validate: function (value) {
                    return !(/^[^\u4E00-\u9FFF]$/g.test(value));
                },
                defaultMsg: '请输入非中文字符'
            },
        ]
    };
    /* 密码由字母和数字 组成，至少6位 */
    var safePassword = function (value) {
        return !(/^(([A-Z]*|[a-z]*|\d*|[-_\~!@#\$%\^&\*\.\(\)\[\]\{\}<>\?\\\/\'\"]*)|.{0,5})$|\s/.test(value));
    };
    //判断包含两个中文
    function twoChinese(value) {
        var str = value.replace(/[^\u4e00-\u9fa5]/gi, "");
        if (str.length < 2) {
            return false;
        }
        return true;
    };
    //俄文或英文两选一输入


    /*身份证验证*/
    var idCard = function (value) {
        if (value.length == 18 && 18 != value.length) return false;
        var number = value.toLowerCase();
        var d, sum = 0, v = '10x98765432', w = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2], a = '11,12,13,14,15,21,22,23,31,32,33,34,35,36,37,41,42,43,44,45,46,50,51,52,53,54,61,62,63,64,65,71,81,82,91';
        var re = number.match(/^(\d{2})\d{4}(((\d{2})(\d{2})(\d{2})(\d{3}))|((\d{4})(\d{2})(\d{2})(\d{3}[x\d])))$/);
        if (re == null || a.indexOf(re[1]) < 0) return false;
        if (re[2].length == 9) {
            number = number.substr(0, 6) + '19' + number.substr(6);
            d = ['19' + re[4], re[5], re[6]].join('-');
        } else d = [re[9], re[10], re[11]].join('-');
        if (!isDateTime.call(d, 'yyyy-MM-dd')) return false;
        for (var i = 0; i < 17; i++) sum += number.charAt(i) * w[i];
        return (re[2].length == 9 || number.charAt(17) == v.charAt(sum % 11));
    }

    var isDateTime = function (format, reObj) {
        format = format || 'yyyy-MM-dd';
        var input = this, o = {}, d = new Date();
        var f1 = format.split(/[^a-z]+/gi), f2 = input.split(/\D+/g), f3 = format.split(/[a-z]+/gi), f4 = input.split(/\d+/g);
        var len = f1.length, len1 = f3.length;
        if (len != f2.length || len1 != f4.length) return false;
        for (var i = 0; i < len1; i++) if (f3[i] != f4[i]) return false;
        for (var i = 0; i < len; i++) o[f1[i]] = f2[i];
        o.yyyy = s(o.yyyy, o.yy, d.getFullYear(), 9999, 4);
        o.MM = s(o.MM, o.M, d.getMonth() + 1, 12);
        o.dd = s(o.dd, o.d, d.getDate(), 31);
        o.hh = s(o.hh, o.h, d.getHours(), 24);
        o.mm = s(o.mm, o.m, d.getMinutes());
        o.ss = s(o.ss, o.s, d.getSeconds());
        o.ms = s(o.ms, o.ms, d.getMilliseconds(), 999, 3);
        if (o.yyyy + o.MM + o.dd + o.hh + o.mm + o.ss + o.ms < 0) return false;
        if (o.yyyy < 100) o.yyyy += (o.yyyy > 30 ? 1900 : 2000);
        d = new Date(o.yyyy, o.MM - 1, o.dd, o.hh, o.mm, o.ss, o.ms);
        var reVal = d.getFullYear() == o.yyyy && d.getMonth() + 1 == o.MM && d.getDate() == o.dd && d.getHours() == o.hh && d.getMinutes() == o.mm && d.getSeconds() == o.ss && d.getMilliseconds() == o.ms;
        return reVal && reObj ? d : reVal;
        function s(s1, s2, s3, s4, s5) {
            s4 = s4 || 60, s5 = s5 || 2;
            var reVal = s3;
            if (s1 != undefined && s1 != '' || !isNaN(s1)) reVal = s1 * 1;
            if (s2 != undefined && s2 != '' && !isNaN(s2)) reVal = s2 * 1;
            return (reVal == s1 && s1.length != s5 || reVal > s4) ? -10000 : reVal;
        }
    };


    var formState = false, fieldState = false, wFocus = false, globalOptions = {};

    var validateField = function (field, valid, param) { // 验证字段
        var el = $(field), error = false, errorMsg = '';
        for (var i = 0; i < valid.length; i++) {
            var x = true, flag = valid[i], msg = (el.attr(flag + '-message') == undefined) ? null : el.attr(flag + '-message');

            if (flag.substr(0, 1) == '!') {
                x = false;
                flag = flag.substr(1, flag.length - 1);
            }

            var rules = globalOptions.validRules;
            for (j = 0; j < rules.length; j++) {
                var rule = rules[j];
                if (flag == rule.name) {
                    if (rule.validate.call(field, el.val().trim(), param) == x) {
                        error = true;
                        errorMsg = (msg == null) ? rule.defaultMsg : msg;
                        break;
                    } else {
                        error = false;
                        fieldState = true;
                        break;
                    }
                }
            }

            if (error) {
                break;
            }
        }

        var controls = el.parents('.controls'), controlGroup = el.parents('.control-group'), errorEl = controlGroup.children('.help-block, .help-inline');

        if (error) {
            var required = el.attr("required");
            if (valid[0] != required && required == null && $.trim(el.val()).length == 0) {
                return error;
            }
            if (!controls.hasClass('error')) {
                if (errorEl.length > 0) {
                    var help = errorEl.text();
                    controlGroup.data('help-message', help);
                    errorEl.text(errorMsg);
                } else {
                    if ("{!}" != msg) {
                        controlGroup.append('<span class="help-inline">' + errorMsg + '</span>');
                    }
                }
                controls.attr('class', 'controls error');
            }
        } else {

            if (fieldState) {
                if (errorEl.length > 0) {
                    var help = controlGroup.data('help-message');
                    if (help == undefined) {

                        errorEl.remove();
                    } else {

                        errorEl.text(help);
                    }
                }
                controls.attr('class', 'controls success');
            } else {
                if (errorEl.length > 0) {
                    var help = errorEl.text();
//                    el.addClass("error");
                    controlGroup.data('help-message', help);
                }
            }
        }
        return !error;
    };
    var getPos = function (node) {
        var scrollx = document.documentElement.scrollLeft || document.body.scrollLeft,
            scrollt = document.documentElement.scrollTop || document.body.scrollTop;
        var pos = node.getBoundingClientRect();
        return {
            top: pos.top + scrollt,
            right: pos.right + scrollx,
            bottom: pos.bottom + scrollt,
            left: pos.left + scrollx
        }
    };
    var validationForm = function (obj) { // 表单验证方法
        $(obj).submit(function () { // 提交时验证
            /*if (formState) { // 重复提交则返回
             return false;
             }*/
            formState = true;
            var validationError = false;
            $('input, textarea', this).each(function () {
                var el = $(this), valids = (el.attr('check-type') == undefined) ? null : el.attr('check-type').split(' ');
                if (valids != null && valids.length == 2) {
                    valid = valids[0].split(' ');
                    param = valids[1];

                } else {
                    param = undefined;
                    valid = valids;

                }
                if (valid != null && valid.length > 0) {
                    if (!validateField(this, valid, param)) {
                        if (wFocus == false) {
                            scrollTo(0, getPos(el[0]).top - 50);
                            wFocus = true;
                        }
                        validationError = true;
                    }
                }
            });

            wFocus = false;
            fieldState = true;

            if (validationError) {
                formState = false;

                $('input, textarea').each(function () {
                    var el = $(this), valid = (el.attr('check-type') == undefined) ? null : el.attr('check-type').split(' ');
                    if (valid != null && valid.length > 0) {
                        el.focus(function () { // 获取焦点时
                            // console.log(this);
                            //alert("验证问题");
                            var controls = el.parents('.controls'), controlGroup = el.parents('.control-group'), errorEl = controlGroup.children('.help-block, .help-inline');
                            if (errorEl.length > 0) {
                                var help = controlGroup.data('help-message');
                                if (help == undefined) {
                                    errorEl.remove();
                                } else {
                                    errorEl.text(help);
                                }
                            }
                            //console.log('el.focus');

                            controls.attr('class', 'controls');
                            //if($(this).hasClass('bianhai')){
                            //    var that=$(this);
                            //    var hai=that.parents('.bianfu');
                            //    hai=hai.find('.xialapin');
                            //    hai.show();
                            //}
                        });

                        el.blur(function () {
                            // 失去焦点时
                            // console.log(this);
                            var el = $(this), valids = (el.attr('check-type') == undefined) ? null : el.attr('check-type').split(' ');

                            if (valids.length == 2) {
                                valid = valids[0].split(' ');

                                param = valids[1];

                            } else {
                                param = undefined;
                                valid = valids;

                            }
                            //console.log('el.blur')
                            validateField(this, valid, param);
                        });
                    }
                });
                return false;
            }

            return globalOptions.onBefore();
        });


    };
}(window.jQuery);
