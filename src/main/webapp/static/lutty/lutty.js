(function ($) {
    $('input[type="radio"][data-showfor][data-hidefor]').each(function () {

        var that = $(this);
        var ibreak = that.data("break");
        var hidefor = that.data("hidefor");
        var showfor = that.data("showfor");
        if (hidefor != undefined || showfor != undefined) {
            that.change(function () {
                if (hidefor != undefined) {
                    $(hidefor).hide();
                    //$(hidefor).find("input:text,input:file").val("");
                    $(hidefor).find("input:text,input:file,textarea").removeAttr("required");
                }
                if (showfor != undefined) {
                    //$(showfor).find("input:text,input:file").val("");
                    if (!$(showfor).find("input:text,input:file,textarea").is(".not-required")) {
                        $(showfor).find("input:text,input:file,textarea").attr("required", "required");
                        $(showfor).find("input:text,input:file,textarea").removeAttr('disabled');
                    }
                    $('#takeStartTime').removeAttr("required");
                    $('#takeEndTime').removeAttr("required");
                    $(showfor).show();
                }
            });
            if (that.is(':checked')) {
                if (hidefor != undefined) $(hidefor).hide();
                if (showfor != undefined) $(showfor).show();
            }
        }
    });

    var ogids = '';
    $('.input_addon_item .input_addon_del').click(function () {
        var $parent = $(this).parent();
        var ogid = $($parent.data("to")).val();
        ogids += ogid + ',';
        $('#ogids').val(ogids.substring(0, ogids.length - 1));
        $parent.parent().remove();
        $('#changeParcel').val('true');
    });

    $('.goods_input').change(function () {
        $('#changeParcel').val('true');
    });


    $(".input_addon").each(function () {
        var that = $(this);
        var from = that.data("addform");
        var fromHTML = $(from).prop('outerHTML');
        var fromID = $(from).attr("id");
        var to = that.data("addfor");
        var canDel = that.data("candel");

        that.click(function () {
            var index = that.attr("index");
            var group = $(fromHTML.replace(new RegExp('details\\[0\\]', "g"), 'details[' + index + ']'));
            group.addClass("input_addon_item");
            if (canDel) {

                var delButton = $('<div><span class="input_addon_del"></span></div>');
                delButton.addClass("addon_del");
                $('#changeParcel').val('true');
                group.append(delButton);
            }


            $(to).append(group);
            that.attr("index", index - (-1))
        });
    });
    var flag = $('#flag').val();
    if (flag) {
        alert("未找到对应运价！");
    }
})(jQuery);