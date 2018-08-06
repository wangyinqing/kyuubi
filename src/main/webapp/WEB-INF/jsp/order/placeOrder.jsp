<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/include/taglib.jsp" %>
<%@ include file="/WEB-INF/include/head.jsp" %>
<html>
<head>
    <title>收货人信息</title>
    <link href="${ctxStatic}/order.css" type="text/css" rel="stylesheet"/>
    <link href="${ctxStatic}/style.css" type="text/css" rel="stylesheet"/>
    <link href="${ctxStatic}/lutty.css" type="text/css" rel="stylesheet"/>
    <link rel="stylesheet" href="${ctxStatic}/city/cityselect.css"/>
    <script src="${ctxStatic}/city/city.js"></script>

    <style type="text/css">
        body {
            font-size: 14px;
        }

        .hideinfos, .csoye {
            display: none;
            width: 292px;
            border: 1px solid #e9eff3;
            background: #f3f3f3;
            margin-left: 305px;
            padding: 8px 0;
            padding-left: 42px;
        }

        .popup-button {
            cursor: pointer
        }

        .goods_input {
            margin-right: 0
        }

        .cs {
            border: 1px solid #FFF
        }

        .control-group-stl {
            line-height: 2.2rem;
            padding: 0 0.5rem;
            display: table-cell;
            vertical-align: middle
        }

        .addon_del {
            display: table-cell;
            vertical-align: middle
        }

        .file-del {
            color: #ff0011;
            margin-left: 10px;
            display: none
        }

        .info_table_tittle b {
            color: red
        }

        .help-inline {
            margin-left: inherit;
            position: static
        }

        .select_wrap {
            display: inline-block;
            position: relative;
        }

        .vsre {
            background: #fff;
            float: left;
            width: 220px;
            height: 50px;
            line-height: 50px;
            font-size: 16px;
            border-radius: 5px;
            -moz-border-radius: 5px;
            -webkit-border-radius: 5px
        }

        .fdsfrw {
            position: absolute;
            left: 0;
            top: 50px;
            z-index: 500;
            border: 1px solid #dddddd;
            border-bottom: 0px;
            display: none;
            overflow-x: hidden;
            overflow-y: scroll;
            width: 100%;
            height: 300px;
            background-color: #fff
        }

        .vsre .select_txt {
            font-size: 13px;
            vertical-align: bottom;
            vertical-align: text-bottom;
        }

        .prompt_notice {
            color: #FF3300;
            text-align: left;
            font-weight: bold;
            font-size: 14px;
        }

        .special_notice p {
            margin-bottom: -1px;
            margin-top: -15px;
        }

        .special_notice {
            /* margin-top: -50px; */
            border-radius: 10px;
            background: #eef2fa;
            overflow: hidden;
            padding: 10px;
            margin: 20px auto;
            width: 748px;
        }

        .declare_intro .cell_left_con {
            width: 400px;
            line-height: 1.5;
            color: #f00;
        }

        .placeorder .info_area .copy_input1 {
            width: 220px;
            line-height: 28px;
            margin: 0;
            border-radius: 0px;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 5px;
            height: 38px;
            line-height: 38px;
        }

        .placeorder .info_area .copy_input2 {
            height: 28px;
            width: 220px;
            line-height: 28px;
            margin: 0;
            border-radius: 0px;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 5px;
            height: 38px;
            line-height: 38px;
        }

        .placeorder .info_area .copy_input3 {
            height: 28px;
            width: 220px;
            line-height: 28px;
            margin: 0;
            border-radius: 0px;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 5px;
            height: 38px;
            line-height: 38px;
        }

        .declare_intro {
            width: 100%;
            color: #f00;
            font-size: 14px;
            height: 45px;
            background: #e9efff;
            text-align: center;
            line-height: 45px;
            border-radius: 5px;
            margin: 20px 0;
        }

        .placeorder .mark_red {
            margin-left: 245px;
        }

        .input_addon_del {
            margin-left: -10px;
            position: absolute;
            top: 0;
            right: -37px;
            width: 30px;
            color: #6583fb;
            font-weight: 500;
            background: none;
        }

        input.goods_input {
            width: 50px;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 5px;
            height: 38px;
            line-height: 38px;
        }

        .place_goods_info .control-group.control-group-stl {
            font-size: 12px;
        }

        .memo {
            overflow-y: auto;
            padding: 15px;
            max-height: 250px;
            color: #555;
        }

        .Wdate {
            margin: 0px;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 5px;
            height: 38px;
            line-height: 38px;
            color: #333;
            padding-left: 5px;
            width: 220px;
        }

        .placeorder .cell_hd_in {
            min-width: inherit;
            text-align: inherit;
            width: auto;
            vertical-align: middle;
        }

        .placeorder .cell_left_con {
            /*margin-right: 5px;*/
        }

        .placeorder .unit_red {
            color: #ff0012;
        }

        .placeorder .unit {
            font-size: 12px;
            font-weight: 200;
        }

        .placeorder .info_area .input {
            color: #333;
            width: 242px;
        }

        .placeorder .info_area .newShowFor .input {
            color: #333;
            width: 365px;
        }

        .upload_btns {
            margin: 0 8px 0 15px;
            border-radius: 5px;
            width: 70px;
            height: 38px;
            line-height: 38px;
            color: #fff;
            background: #6583fb;
            cursor: pointer;
        }

        .pop_mask_layer {
            display: none;
            position: fixed;
            right: 0;
            bottom: 0;
            left: 0;
            top: 0;
            z-index: 100000;
            background-color: #000;
            opacity: .3;
            filter: alpha(opacity=30);
        }

        .pop_ups {
            display: none;
            position: absolute;
            left: 50%;
            right: 50%;
            z-index: 100001;
        }

        .pop_ups .pop_ctn {
            /*width: 500px;*/
            margin: 0 auto;
            overflow: hidden;
            transform: translateX(-50%);
            -ms-transform: translateX(-50%);
            -moz-transform: translateX(-50%);
            -webkit-transform: translateX(-50%);
            -o-transform: translateX(-50%);
            /*border: 1px solid #e1e1e1;*/
            border-radius: 5px;
            color: #999;
            box-shadow: 1px 1px 3px #666;
            background: #fff;
        }

        .pop_ups .pop_content {
            width: 500px;
            margin: 0 auto;
            overflow: hidden;
            transform: translateX(-50%);
            -ms-transform: translateX(-50%);
            -moz-transform: translateX(-50%);
            -webkit-transform: translateX(-50%);
            -o-transform: translateX(-50%);
            /*border: 1px solid #e1e1e1;*/
            border-radius: 5px;
            color: #999;
            box-shadow: 1px 1px 3px #666;
            background: #fff;
        }

        .pop_ups .pop_title {
            background: #6583fb none repeat scroll 0 0;
            color: #fff;
            font-size: 16px;
            font-weight: bold;
            padding: 4px 10px;
            text-align: left;
            width: 100%;
        }

        .pop_ups .pop_title .pop_cancel {
            background: rgba(0, 0, 0, 0) url("/huodoufront/images/pmp_close.png") no-repeat scroll 0 0;
            cursor: pointer;
            float: right;
            height: 29px;
            margin: 3px 5px;
            width: 29px;
        }

        .pop_ups .pop_info {
            margin: 10px;
        }

        .pop_ups .pop_button {
            margin: 10px;
            text-align: center;
            padding: 7px;
        }

        .pop_ups input[type="button"] {
            padding: 6px;
            font-size: 14px;
        }

        .popup-fill {
            position: fixed;
            z-index: 1;
            width: 100%;
            height: 100%;
            background-color: silver;
            display: none;
            opacity: .3;
            left: 0;
            top: 0;
        }

        .qujianInfo {
            width: 570px;
            /*height: 173px;*/
            padding-bottom: 15px;
            background: #f3f3f3;
            margin: 0 auto;
            padding-left: 40px;
            border: 2px solid #e9eeff;
            border-radius: 3px;
        }

        .qujianInfo .qjmbi {
            margin: 8px 0;
        }

        .qujianInfo .qjmbi p {
            line-height: 26px;
            font-size: 14px;
        }

        .place_goods_info .success, .place_goods_info .error, .place_goods_info .controls {
            float: none;
            display: inline-block;
            position: relative;
            vertical-align: middle;
        }

        .xialapin {
            width: 376px;
            padding: 0px 12px;
            position: absolute;
            z-index: 15;
            background: #fff;
            border: 1px solid #cccccc;
            box-shadow: 2px 2px 3px rgba(0, 0, 0, 0.1);
            top: 37px;
            font-family: "Microsoft YaHei", "微软雅黑", Helvetica, Tahoma, STXihei, "华文细黑", STHeiti, "Helvetica Neue", Helvetica, Tahoma, "Droid Sans", "wenquanyi micro hei", FreeSans, Arimo, Arial, SimSun, "宋体", Heiti, "黑体", sans-serif;
        }

        .xialapin p {
            color: #a5a5a5;
            font-size: 12px;
        }

        .xialapin .pinCont {
            /*margin-top: 6px;*/
            height: 120px;
            overflow-y: scroll;
        }

        .xialapin .pinCont li {
            height: 26px;
            cursor: pointer;
            line-height: 26px;
        }

        .xialapin .pinCont li span {
            display: inline-block;
            line-height: 26px;
            height: 26px;
            vertical-align: middle;
        }

        .xialapin .pinCont li .pinId {
            margin-right: 30px;
            width: 83px;
        }

        .xialapin .pinCont li .pinName {
            width: 210px;
            /* overflow: hidden; */
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }

        .xiufyg {
            margin-top: 10px;
        }

        .xiufyg .cs {
            display: inline-block;
            position: relative;
        }

        .xiufyg .control-group-stl {
            padding: 0;
        }

        .xiufyg .danyyg {
            position: absolute;
            background: #e0e0e0;
            padding: 0px 3px;
            min-width: 26px;
            text-align: center;
            top: 0;
            right: 0;
            height: 100%;
            border-bottom-right-radius: 5px;
            border-top-right-radius: 5px;
        }

        .xiufyg input.goods_input {
            min-width: 70px;
        }

        .xiufyg input.goods_input[readonly], .xiufyg input.goods_input[readonly] + .danyyg {
            background: #f1f1f1;
        }

        .xiufyg input.goods_input[readonly] {
            border: 1px solid #f1f1f1;
        }

        .xiufyg .editgui {
            padding: 8px 10px;
            background: #f9f9f9;
            border: 1px solid #6583fb;
            color: #6583fb;
            font-size: 14px;
            font-family: 微软雅黑, sans-serif;
            cursor: pointer;
            border-radius: 3px;
        }

        .xiufyg .editgui.savegui {
            background: #6583fb;
            border: 1px solid #6583fb;
            color: #fff;
        }

        .xiufyg .chengyrt {
            display: table-cell;
            vertical-align: middle;
            padding: 0 5px;
        }

        [danweifu] {
            position: relative;
            border-radius: 5px;
            overflow: hidden;
        }

        [danweifu] .danweizhi {
            position: absolute;
            top: 0;
            right: 0;
            background: #e0e0e0;
            height: 38px;
            line-height: 38px;
            font-size: 13px;
            padding: 0 5px;
        }

        .querBianma {
            color: #414141;
            font-size: 12px;
            text-decoration: underline;
        }

        .querBianma:hover {
            color: #6583fb;
        }

        #visitCountyName {
            width: 90px;
            height: 36px;
            background-color: white;
            border: 1px solid #D8D8D8;
            /*padding: 9px 6px;*/
            border-radius: 2px;
        }

        .placeorder .newShowFor .cell_hd {
            min-width: 242px;
        }

        .placeorder .new_info_0504 .cell_hd {
            font-weight: normal;
        }

        #visitAddr {
            overflow: hidden;
            vertical-align: top;
            resize: none;
            height: 80px;
            line-height: 20px;
            padding: 0 6px;
        }

        .declare_intro.new_declare_intro {
            text-align: left;
            display: inline-block;
            width: auto;
            padding: 0 14px;
            margin-left: 100px;
        }
    </style>


    <script type="text/javascript">

    </script>

</head>
<body>
<div class="container placeorder">
    <form id="form" name="form" action="/order/createOrder" method="post" class="form-horizontal"
          enctype="multipart/form-data" onsubmit="return doValidation();">

        <h3 class="nav_tt">物流方案</h3>
        <ul style="width: 100%;" class="info_area new_info_area new_info_0504">
            <li>

                <span class="cell_hd ">取件地：</span>
                <span class="cell_left_con cell_con_spcl"
                      style="width: 272px;font-weight: 600;vertical-align: text-top;">
                    ${locationProvinceName},${locationCityName},${locationName}
                </span>
                <input type="hidden" id=sendProvinceName name="sender.provinceName" value="上海"/>
                <input type="hidden" id=sendCityName name="sender.cityName" value="上海"/>
                <input type="hidden" id=sendCountyName name="sender.countyName" value="虹口区"/>
                <span class="cell_hd" style="min-width: 176px;">收件地：</span>
                <span class="cell_left_con" style="font-weight: 600;">
                    ${destName}
                </span>
            </li>
            <li>
                <span class="cell_hd">货物品类：</span>
                <span class="cell_left_con cell_con_spcl" style="width: 272px;font-weight: 600;">普货</span>
            </li>

        </ul>
        <div class="special_notice">
            <h3 class="prompt_notice">专线须知：</h3>
            <div class="notice_bd j_notice_bd"></div>
            <div class="notice_bd_hover j_notice_bd_hover memo">售后赔偿：
                <br>1、丢失赔偿标准：按照申报价值赔偿，最高赔偿100USD一票。
                <br>
                <br>*注意：货物产品跟箱子上面必须有MADE ,IN CHINA 标，若为贴标签造成清关延误，异常退回的，由发件人自行承担，货兜不承担此责任。
                <br>特别提示：单件计费重改为12KG，不满12KG的按12KG计费
                <br>1.不收：危险物品、仿牌产品、粉末,液体以及国家规定的所有违禁物品；冲货将移交有关部门处理，做扣货、罚款5000一票处理。
                <br>2.接受：美国全境亚马逊入仓、住宅派送等，包税价格；亚马逊入仓请自行贴好亚马逊入仓纸。
                <br>3.单件最长边超120CM加收150RMB,单件最长边超130CM加收220RMB；
                <br>单件实重超过31KG或者材积超25KG加收RMB150/件，实重超过41KG或者材积超35KG,加收RMB460RMB/件，单件最长边不能超过2.2米，单件计费重量不能超过68KG, 否则无法出口。
                <br>4.需提供电子档发票一份；物品申报需与产品一致，如果因申报不符造成延误或者扣关由发件人自行承担。
                <br>
                <br>备注:此以上渠道只提供美国本土服务，不提供附属岛屿等偏远地区服务，不接受PO BOX等邮箱地址；偏远地区邮编如下：006-009 PUERTO RICO AND VIRGIN LSLANDS
                波多黎各、维尔京群岛，966-969 HAWAIIAND GUAM 夏威夷、关岛,995-999 ALASKA 阿拉斯加等..
                <br>
                <br>1.此价格是含燃油，含税的全包价格；接受所有美国地区派送地址类型包括：亚马逊仓库、私人收件住宅地址;不含偏远，偏远地址将加收30RMB/件收费。
                <br>2.此渠道包税，但是包税产品只接受20%以内的税金限定，产品税率进口关税超过20%将收取超出部分税金；出货前请自行上美国海关官网查询产品进口税率。
                <br>3.此价格为香港CX直飞洛杉矶含美国当地Fdeex派送费用.
                <br>4.接受单独报关需要加收300RMB/票以及3RMB/KG;时效将延迟1个工作日出口!
                <br>5. 不收仿牌产品，此渠道不接受仿牌产品；如产品仿牌、产品本身质量问题或侵权问题导致货物无法清关或延误所有责任由发件人承担。
                <br>6.已发出快件需要扣件的货物将收取150RMB/单件扣货手续费，扣件成功后计算；扣货不保证100%成功，但扣货不成功将不收取费用。
                <br>7.美国快件收件人拒收退回我司美国仓库的，我司将提供7天免费处理期；超过7天我司将按照5RMB/天/件收取仓库保管费；重发将按照我司大陆起步报价表重新计费并收费。
                <br>8,可一票多件但单票超过25件需分单打单，不影响派送。
                <br></div>

        </div>
        <h3 class="nav_tt">货物信息</h3>
        <ul class="info_area new_info_area" id="orderNumUl" style="width: 100%">

            <li class="place_goods_info order_num" data-goods_info-index="0">
                <span class="cell_hd "
                      style="padding-top: 10px;vertical-align: top;min-width: 100px;text-align: right;">
                    <span onclick="deleteHuo(this)" style="display: none;">删除</span>货物信息1：</span>
                <span class="cell_left_con bianfu" style="vertical-align:top;display:inline-block;">
                        <div class="pst_r" style="margin: 10px 0px;">
                            <span class="cell_hd_in"><span class="font_red">*</span>中文品名：</span>
                            <span class="cell_left_con control-group">
                                <div class="controls cs first_col" style="float: initial;">
                                    <input type="hidden" name="details[0].odParcelId" value="">
                                    <input class="input input2 copy_input1 biancn" value="" id="goodsDesc-cn"
                                           name="details[0].cargoName" placeholder="请至少输入两个中文字符" check-type="twoChinese"
                                           twochinese-message="{!}" required=""></div>
                            </span>
                            <span class="cell_hd_in" style="width: 124px;text-align: right;"><span
                                    class="font_red">*</span>英文品名：</span>
                            <span class="cell_left_con control-group">
                                <div class="controls cs first_col" style="float: initial;">
                                    <input class="input input2 copy_input1" value="" id="goodsDesc-en"
                                           name="details[0].cargoEnName" check-type="englishNew"
                                           englishnew-message="{!}" placeholder="请输入英文品名" required="">
                                </div>
                            </span>

                        </div>
                        <div style="margin: 10px 0px;position: relative;">
                            <span class="cell_hd_in"><span class="font_red">*</span>海关编码：</span>
                            <span class="cell_left_con">
                                <div class="control-group">
                                    <div class="controls cs first_col" style="position: relative;">
                                        <input class="input input2  copy_input1 bianhai" id="hcode1"
                                               name="details[0].hsCode" check-type="length 10,10" value=""
                                               length-message="{!}" placeholder="10位海关编码" required=""
                                               autocomplete="off">
                                        <div class="xialapin" style="display: none;">
                                            <p data-html="genju"></p>
                                            <ul class="pinCont">
                                                <li style="position: relative; height: 100%;width: 100%;padding-top: 29px;">
                                                    <div style=" margin: 0 auto;width: 100%;display: block;text-align: center;">
                                                        请在货物信息中输入中文品名<br>
                                                        我们将帮您查询海关编码
                                                    </div>
                                                </li>
                                            </ul>

                                            <p style="text-align: right;"><a href="http://www.hsbianma.com/"
                                                                             class="querBianma" target="_blank"
                                                                             data-html="errorNo">都不对，去网站查询</a></p>
                                        </div>
                                    </div>
                                </div>
                            </span>
                            <span class="cell_hd_in" style="width: 124px;text-align: right;"><span
                                    class="font_red">*</span>申报价值：</span>
                            <span style="display: inline-block;overflow: hidden;vertical-align: middle;">
                                <div class="controls cs" danweifu="" style="position: relative;">
                                    <input class="input input2 copy_input3 j-cpinput" value=""
                                           name="details[0].customsUnitCharge" check-type="decimal"
                                           decimal-message="{!}" placeholder="子商品申报价值" required="">
                                    <span class="danweizhi">$/个</span>
                                </div>
                            </span>

                            <span style="display: none;overflow: hidden;vertical-align: middle; padding-left: 10px  ;  position: absolute;right: -122px;top: 0;">
                               <span class="unit" style="font-weight: 400">总申报价值：<span><span class="unit_red value"
                                                                                             name="details[0].customsTotalCharge">0</span> $/个</span></span>
                             </span>
                        </div>
                    <div class="pst_r" style="margin: 10px 0px;">
                        <span class="cell_hd_in" style="font-weight: 400;color: red">海关编码请查询：</span><span class="unit"
                                                                                                          style="font-weight: 400;color: red"><a
                            href="http://www.hsbianma.com/" class="querBianma" target="_blank" data-html="errorNo">hsbianma.com</a></span>
                    </div>
                    <div class="xiufyg">
                        <span class="cell_hd_in" style="vertical-align: middle;"><span
                                class="font_red">*</span>货物规格：</span>
                        <div style="position: relative;display: inline-block;vertical-align: middle;">

                            <span class="control-group control-group-stl">
                                <span class="controls cs">
                                    <input class="info_input goods_input" placeholder="长" value="1.00"
                                           name="details[0].cargoLength" check-type="decimal" decimal-message="{!}"
                                           required="" readonly="readonly">
                                    <span class="danyyg">cm</span>
                                </span>
                            </span>
                            <span class="chengyrt">X</span>
                            <span class="control-group control-group-stl">
                                <span class="controls cs">
                                    <input class="info_input goods_input" placeholder="宽" value="1.00"
                                           name="details[0].cargoWidth" check-type="decimal" decimal-message="{!}"
                                           required="" readonly="readonly">
                                    <span class="danyyg">cm</span>
                                </span>
                            </span>
                            <span class="chengyrt">X</span>
                            <span class="control-group control-group-stl">
                                <span class="controls cs">
                                    <input class="info_input goods_input" placeholder="高" value="1.00"
                                           name="details[0].cargoHeight" check-type="decimal" decimal-message="{!}"
                                           required="" readonly="readonly">
                                    <span class="danyyg">cm</span>
                                </span>
                            </span>
                            <span class="control-group control-group-stl" style="padding: 0 5px;padding-left: 15px;">
                                <span class="controls cs">
                                    <script>
                                        var kyue = '0.500';
                                        kyue = kyue.substring(0, kyue.length - 1);
                                        document.write('<input class="info_input goods_input" placeholder="毛重" style="min-width: 82px;" value="' + kyue +
                                                '" readonly  name="details[0].cargoWeight" check-type="decimal" decimal-message="{!}" required/>' +
                                                '<span class="danyyg">kg/箱</span>');
                                    </script>

                                </span>
                            </span>
                            <span class="control-group control-group-stl" style="padding: 0 5px;">
                                <span class="controls cs">
                                    <input class="info_input goods_input" placeholder="每箱个数" id="" value="1"
                                           name="details[0].numPerPack" check-type="number" required=""
                                           readonly="readonly">

                                   <span class="danyyg">个/箱</span>
                                </span>
                            </span>
                            <span class="control-group control-group-stl" style="padding: 0 5px;">
                                <span class="controls cs">
                                    <input class="info_input goods_input" placeholder="数量" value="1"
                                           name="details[0].packageNum" check-type="number" number-message="{!}"
                                           required="" readonly="readonly">

                                    <span class="danyyg">箱数</span>
                                </span>
                            </span>
                            <span class="control-group control-group-stl" style="padding: 0px 15px;">
                                <span class="editgui j_editguige">编辑</span>
                            </span>

                        </div>
                    </div>

                     <div style="margin: 10px 0px;position: relative;">
                         <span class="cell_hd_in">总申报价值：</span>
                         <span name="details[0].customsTotalCharge" style="font-family: 微软雅黑, sans-serif;">


                                                          <span class="totalJin font_red"
                                                                style="font-size: 16px;">0</span>


                             <span class="totalInfo" style="font-size: 14px;">
                                 $=申报价值
                                                                   <span style="font-size: 16px;"
                                                                         class="customsUnitCharge">
                                  0
                                </span>


                                 $
                                 &nbsp;
                                 *
                                 &nbsp;
                                 每箱
                                 <span class="numPerPack" style="font-size: 16px;">
                                     1
                                 </span>
                                 个数
                                 &nbsp;
                                 * &nbsp;总共
                                 <span class="packageNum" style="font-size: 16px;">
                                 1
                             </span>
                                 箱数
                             </span>
                         </span>
                     </div>
                              </span>

            </li><!--默认信息-->
            <li class="place_goods_info addHuo" style="display: none;">
                <span class="" onclick="addHuo(this)">添加货物</span>
            </li>
            <script>
                function addHuo(obj) {
                    var t = $(obj);
                    var addp = t.parents('.addHuo');
                    $('#orderNumUl').find('[data-goods_info-index]');
                    var dd = $('#orderNumUl').find('[data-goods_info-index]').eq(0).clone(true);
                    var num = $('#orderNumUl').find('[data-goods_info-index]').length;
                    dd.attr('data-goods_info-index', num);
                    dd.find('.cell_hd').html('<span onclick="deleteHuo(this)">删除</span>货物信息' + (num + 1));
                    dd.find('input').each(function () {
                        var td = $(this);
                        td.attr('name', td.attr('name').replace(/[\d]/, num));
                    });
                    addp.before(dd);
                }
                function forNum(liEle, num) {

                }
                function deleteHuo(obj) {
                    var t = $(obj);
                    var p = t.parents('[data-goods_info-index]');
                    if (p.attr('data-goods_info-index') == 0) {
                        return false;
                    }
                    p.remove();
                    var num = 0;
                    $('#orderNumUl').find('[data-goods_info-index]').each(function () {
                        var that = $(this);
                        that.attr('data-goods_info-index', num);
                        that.find('.cell_hd').html('<span onclick="deleteHuo(this)">删除</span>货物信息' + (num + 1));
                        that.find('input').each(function () {
                            var td = $(this);
                            td.attr('name', td.attr('name').replace(/[\d]/, num - 1));
                        });
                        ++num;
                    });
                }
            </script>
            <li id="is_error">
                <div class="declare_intro">
                    <span class="lvwen"></span>
                    <span>产品总申报金额务必填写实际市场价值，虚报或者低报都会导致海关扣货及清关延误或海关强制退运等情况，风险均由用户自身承担！</span>
                </div>
            </li>
        </ul>
        <h3 class="nav_tt">取件方式</h3>
        <ul class="info_area new_info_area" style="width: 100%;">
            <li>
                <span class="cell_hd " style="width: 242px;">上门取件：</span>
                <input type="radio" name="ordType" id="ordType-true" checked="checked" data-showfor=".ordType-true-show"
                       data-hidefor=".ordType-false-show" value="2"/>
                <label for="ordType-true">是</label>
                <input type="radio" name="ordType" id="ordType-false" data-hidefor=".ordType-true-show"
                       data-showfor=".ordType-false-show" value="1"/>
                <label for="ordType-false" style="margin-left: 12px;">否</label>
                <input name="doorType" value="" type="hidden"/>
            </li>

            <li class="visit ordType-true-show" style="display:none;">
                <ul data-showfor="showfor" class="newShowFor">
                    <li>
                        <span class="btn_blue" id="getContacts1"
                              style="margin-left: 245px;width: 160px;height: 32px;line-height: 32px;font-size: 14px;text-align: center;"
                              data-type="0">+选择联系人 </span>
                    </li>
                    <li style="margin: 10px 0px;">
                        <input type="hidden" name="doorToDoor.ctype" value="3">
                        <span class="cell_hd "><span class="font_red">*</span>联&nbsp;&nbsp;系&nbsp;&nbsp;人：</span>
                        <input type="text" style="margin: 0;" class="input input2 required" placeholder="请输入联系人"
                               value="" check-type="nohtml" name="doorToDoor.collectName" id="visitName" required/>
                    </li>

                    <li style="margin: 10px 0px;">
                        <span class="cell_hd "><span class="font_red">*</span>联系方式：</span>
                        <!-- check-type="number" -->
                        <div class="controls" style="float: inherit;display: inline-block;">
                            <input type="text" style="margin: 0;" placeholder="请输入联系方式" class="input input2 required"
                                   value="" name="doorToDoor.collectMobile" id="visitTel" required/>
                        </div>
                    </li>

                    <li style="margin: 10px 0px;">
                        <span class="cell_hd "><span class="font_red">*</span>取件地点：</span>
                        <div class="control-group cell_left_con">
                            <div class="controls cs cell_left_con" style="position: relative;">
                                <input class="input input2" style="margin: 0;" placeholder="请选择所属地" id="newDoorToDoor"
                                       type="text" value="${locationProvinceName},${locationCityName},${locationName}"/>
                                <i><img src="${ctxStatic}/images/xianxia.png" alt=""
                                        style="position: absolute;z-index: 2;right: 0;top: 0;height: 37px;border-bottom-right-radius: 5px;border-top-right-radius: 5px;"></i>
                                <input type="hidden" name="doorToDoor.provinceName" value=""/>
                                <input type="hidden" name="doorToDoor.cityName" value=""/>
                                <input type="hidden" name="doorToDoor.countyName" value=""/>
                                <input type="hidden" name="doorToDoor.provinceCode" value=""/>
                                <input type="hidden" name="doorToDoor.cityNameCode" value=""/>
                                <input type="hidden" name="doorToDoor.countyCode" value=""/>

                            </div>
                        </div>
                    </li>
                    <li style="margin: 10px 0px;">
                        <input type="hidden" name="doorToDoor.ctype" value="3">
                        <span class="cell_hd "><span class="font_red">*</span>详细地址：</span>
                        <div class="control-group cell_left_con">
                            <div class="controls cs cell_left_con">
                                <textarea class="input" id="visitAddr" placeholder="请输入详细地址" name="doorToDoor.addr"
                                          required></textarea>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div style="padding-left: 215px;">
                            <label>
                                <i class="rdo agree saveLink"></i>
                                保存联系人信息</label>
                        </div>
                    </li>


                    <li class="font_red" style="margin: 7px 0 0 80px;line-height: 20px;display: none;">
                    <span>注:下单后,,请勿私自联系取件,
                        否则产生的货物损失将由用户自身负责！
                        <br/>
                            &nbsp&nbsp&nbsp&nbsp&nbsp请将货兜单号标注在到包裹外包装，如有商业发票也请附上，以便入库和顺利报关！
                        </span></li>
                    <li class="declare_intro" style="line-height: 12px; height: 54px; width: 900px;">
                        <span class="lvwen" style="margin-top:5px;">
                        </span>
                         <span style="display: inline-block; width: 830px;line-height: 18px;vertical-align: middle;margin-top: 10px;text-align: left;font-size: 14px;">注:下单后,,请勿私自联系取件,
                        否则产生的货物损失将由用户自身负责！请将货兜单号标注在到包裹外包装，如有商业发票也请附上，以便入库和顺利报关！
                        </span>
                    </li>

                </ul>
            </li>
            <li class="self_help ml_10 ordType-false-show">
                <ul class="newShowFor">
                    <li class="font_red mark_red">请将货物送到以下地址:</li>

                    <li>
                        <span class="cell_hd ">仓库地址：</span>
                        <span class="cell_left_con">深圳市 福永镇白石厦新塘工业园（兴富为工业园2号厂房B栋1楼货兜公司）, 九尾狐-广州仓库收</span>
                    </li>

                    <li>
                        <span class="cell_hd ">收&nbsp;货&nbsp;人：</span>
                        <span class="cell_left_con">
                            <a href="#" class="color-blue">贾老板</a>
                        </span>
                    </li>

                    <li>
                        <span class="cell_hd ">仓库总机：</span>
                        <span class="cell_left_con">021-88886666(座机)</span>
                    </li>

                    <li>
                        <span class="cell_hd ">工作时间：</span>
                        <span class="cell_left_con">工作日9:00-17:00</span>
                    </li>
                    <li>
                        <span class="cell_hd ">温馨提示：</span>
                        <span class="cell_left_con">请在包裹外包装写上九尾狐单号以便加快入仓速度</span>
                    </li>
                    <li class="font_red mark_red">注：仓库收货时间（工作日9:00-17:00）</li>
                    <li class="font_red mark_red">订单提交后，请及时至个人中心-我的订单完善取件方式物流信息</li>
                </ul>
            </li><!--取件方式-------------------------------------end-->
        </ul>
        <script>
            $('.j_editguige').click(function () {
                var that = $(this);
                var xiufyg = that.parents('.xiufyg');
                if (!that.hasClass('savegui')) {
                    xiufyg.find('input.goods_input').removeAttr('readonly');
                    that.addClass('savegui');
                    that.html('确定')
                    return false;
                }
                that.removeClass('savegui');
                xiufyg.find('input.goods_input').attr('readonly', true);
                that.html('编辑');
            });
            var haibian = {
                name: null,
                obj: null,
                code: null
            };
            $('.biancn').blur(function (e) {
                var text = $(this).val();
                if ($.trim(text)) {
                    haibian.name = text;
                    haibian.obj = $(this);
                    haibian.code = null;
                } else {
                    haibian.name = null;
                }
                ;
                //$('.youebain').show();
                $(this).parents('.bianfu').find('.xialapin').hide();

            });

            function setTotalVal(obj) {
                var s = 0;
                var details = obj.attr("name").substring(0, obj.attr("name").indexOf(".") + 1);
                var numberOfEach = $('[name="' + details + 'numPerPack"]').val();
                var singleValue = $('[name="' + details + 'customsUnitCharge"]').val();
                var boxQty = $('[name="' + details + 'packageNum"]').val();
                if (null == numberOfEach) {
                    numberOfEach = 0;
                }
                if (null == singleValue) {
                    singleValue = 0;
                }
                if (null == boxQty) {
                    boxQty = 0;
                }

                $('[name="' + details + 'customsTotalCharge"]').find('.totalJin').html((numberOfEach * singleValue * boxQty).toFixed(2));

                $('[name="' + details + 'customsTotalCharge"]').find('.customsUnitCharge').html(singleValue);
                $('[name="' + details + 'customsTotalCharge"]').find('.numPerPack').html(numberOfEach);
                $('[name="' + details + 'customsTotalCharge"]').find('.packageNum').html(boxQty);
            }

            $(function () {

                $('[name$="\\]\\.planQty"],[name$="\\]\\.customsUnitCharge"],[name$="\\]\\.numPerPack"],[name$="\\]\\.packageNum"]').keypress(function (e) {
                    var e = e ? e : (window.event ? window.event : null);
                    var ev = e.keyCode || e.which || e.charCode;
                    var t = $(this), v = t.val(), v1 = String.fromCharCode(ev);

                    if (ev == 8 && navigator.userAgent.indexOf("Firefox") > -1) {
                        return true
                    }
                    return /^[0-9]{1,18}(\.\d{0,2})?$/gi.test(v + '' + v1)
                });
                $('[name$="\\]\\.planQty"],[name$="\\]\\.customsUnitCharge"],[name$="\\]\\.numPerPack"],[name$="\\]\\.packageNum"]').keyup(function (e) {
                    var e = e || window.event;
                    var t = $(this);
                    setTotalVal(t)
                });
                $('[name$="\\]\\.planQty"],[name$="\\]\\.customsUnitCharge"],[name$="\\]\\.numPerPack"],[name$="\\]\\.packageNum"]').blur(function () {
                    var t = $(this);
                    setTotalVal(t)
                });

                function getCookie(cookieName) {
                    var cookieObj = {},
                            cookieSplit = [],
                    // 以分号（;）分组
                            cookieArr = document.cookie.split(";");
                    for (var i = 0, len = cookieArr.length; i < len; i++)
                        if (cookieArr[i]) {
                            // 以等号（=）分组
                            cookieSplit = cookieArr[i].split("=");
                            // Trim() 是自定义的函数，用来删除字符串两边的空格
                            cookieObj[cookieSplit[0].trim()] = cookieSplit[1].trim();
                        }
                    return cookieObj[cookieName];

                }


                if (!$('#to').text()) {
                    var str = "";
                    if (!!decodeURI(getCookie('outfromArea_provinceName'))) {
                        str += decodeURI(getCookie('outfromArea_provinceName'));
                    }
                    if (!!decodeURI(getCookie('outfromArea_cityName'))) {
                        str += (" , " + decodeURI(getCookie('outfromArea_cityName')));
                    }
                    if (decodeURI(getCookie('outfromArea_disName')) != 'undefined') {
                        str += (" , " + decodeURI(getCookie('outfromArea_disName')))
                    }
                    $('#to').text(decodeURI(getCookie('outToArea_cityName')));
                }


                var errorMsg = '';
                if ('' != '' || true == '') {
                    var errorJson = eval('(' + errorMsg + ')');
                    if ('导入文件有误,是否下载' == errorJson.message) {
                        $("html,body").animate({scrollTop: "2000px"})
                        hdAlert.confirm("导入文件有误,是否下载", function (f) {
                            if (f) {
                                var url = "/bd/fileManager/down.io";
                                var form = '<form action="' + url + '" method="POST">';
                                form += '<input type="hidden" name="dir" value=""/>';
                                form += '<input type="hidden" name="name" value="fail.xlsx"/>';
                                form += '</form>';
                                $(form).appendTo('body').submit().remove();
                            }
                        });
                        return;
                    } else {
                        $("html,body").animate({scrollTop: "2000px"})
                        hdAlert.alert(errorJson.message);
                    }
                }


            });

            $(".sel_send").click(function () {
                $(".linkers_box :radio:checked").each(function (i, dom) {
                    $.post('/front/topContracts/getContract.json', {id: $(this).val()}, function (datas) {
                        for (var i in datas.msg) {
                            var d = datas.msg[i];
                            datas.msg[i] = !!d ? d : "";
                        }
                        if (datas.success) {
                            $("#visitName").val(datas.msg.contract);
                            $("#visitTel").val(datas.msg.mobile == "" ? datas.msg.tel : datas.msg.mobile);
                            $("#visitCountyName").val(datas.msg.countyName);
                            $("#visitAddr").val(datas.msg.addr);
                            if (null == datas.msg.cityName || "" == datas.msg.cityName) {
                                $("#visitAddr").val(datas.msg.addr);
                            } else if (null == datas.msg.countyName || "" == datas.msg.countyName) {
                                $("#visitAddr").val(datas.msg.addr);
                            } else {
                                $("#visitAddr").val(datas.msg.addr);
                            }
                        }
                    }, "json");
                });
                $(".linkers_box").hide();
            });
            var newDoorToDoor = new Vcity.CitySelector({
                input: 'newDoorToDoor', callback: function (obj, box, input) {
                    var that = $(input);
                    if (obj.length == 3) {
                        $('[name="doorToDoor.provinceName"]').val(obj[0].areaName);
                        $('[name="doorToDoor.cityName"]').val(obj[1].areaName);
                        $('[name="doorToDoor.countyName"]').val(obj[2].areaName);

                        return false;
                    }
                    ;
                    $('[name="doorToDoor.provinceName"]').val('');
                    $('[name="doorToDoor.cityName"]').val('');
                    $('[name="doorToDoor.countyName"]').val('');
                }
            });
        </script>

        <!--------------------报关信息start---------------------------->
        <!--------------------报关信息end------------------------------>

        <h3 class="nav_tt">运费详情</h3>
        <div class="info_table" style="display: block;">
            <div class="info_table_row" style="display: table-row;">
                <span class="info_table_tittle">预算费用：</span>
                <div class="info_table_content font-flat color-blue" style="display: table-cell;">
                    ￥55441.00
                    <input name="estimateAmount" type="hidden" value="55441.00" id="estimateAmount"/>
                </div>
                <label style="margin-left: 60px; display: block;"><span class="btnsldjf"
                                                                        style="color: #66f;">展开明细</span></label>
            </div>
            <!--附加费明细-->
            <div class="hideinfos">

                <p class="yusmx">
                    <span class="fjname">物流运费:</span>
                    <span class="fjvalue">2521.00</span>
                </p>
                <p class="yusmx">
                    <span class="fjname">最低起运附加费:</span>
                    <span class="fjvalue">52920.00</span>
                </p>
            </div>
            <div class="info_table_row">
                <span class="info_table_tittle">是否需要发票:</span>
                <div class="info_table_content">
                    <input type="radio" name="invoice" id="isInvoice-true" data-showfor=".isInvoice-true-show"
                           value="1"/>
                    <label for="isInvoice-true">是</label>
                    <input type="radio" name="invoice" id="isInvoice-false" checked="checked"
                           data-hidefor=".isInvoice-true-show" value="0"/>
                    <label for="isInvoice-false">否</label>
                </div>
            </div>
        </div>
        <div style="margin: -20px 0 20px 215px;font-size:14px;font-weight:500;color:#f00;">
            开票需要补收6个点，运费得支付到我司公账，如需开票请务必先联系客服或业务员，请知悉！
        </div>

        <h3 class="nav_tt">备注信息</h3>
        <div class="info_table">
            <div class="info_table_row">
                <span class="info_table_tittle">备注信息:</span>
                <div class="info_table_content font-flat">
                    <input class="info_input" id="memo" name="memo" value=""/>
                </div>
            </div>
        </div>

        <div class="button-area text-center">
            <input class="btn-default color-blue linkSubmit" type="submit" value="提交订单"/>
        </div>

        <script type="text/javascript" src="${ctxStatic}/orderForm.js"></script>
        <script type="text/javascript">
            $('[name="sender.mobile"]').change(function () {
                $(this).val()
                $('#baoMobile').val($(this).val());
            });
            $('[name="sendTel"]').change(function () {
                if (!$('[name="sender.mobile"]').val()) {
                    $('#baoMobile').val($('[name="sendAreano"]').val() + $(this).val());
                }
            });
            function haidetq() {
                $('[data-pop="syn_suc"]').hide();
                $('.pop_mask_layer').hide();
            }
            function tijiaojy() {
                haidetq();
                createTel();
                $('#form').submit();
            }
            $('.shouqis').click(function (e) {
                var that = $(this);
                $('.showesinfo').slideToggle(150, function () {
                    $('.showesinfo').is(":hidden") ? that.html('展开明细') : that.html('收起明细');
                });
            });
            $('.btnsldjf').click(function (e) {
                var that = $(this);
                $('.hideinfos').slideToggle(150, function () {
                    $('.hideinfos').is(":hidden") ? that.html('展开明细') : that.html('收起明细');
                });
            });
            function doValidation() {
                if ($('.jiaoyanpy').hasClass('dis') && "false") {
                    $('[data-pop="syn_suc"]').show();
                    $('.pop_mask_layer').show();
                    return false;
                }
                if (!$("#xuanze").is(":checked") && $("#xuanze").length > 0) {
                    alert('请阅读并接受兜保服务的相关协议！')
                    return false;
                }
                return true;
            }
            $(function () {

                $(".agree").click(function () {
                    if ($(this).is(".rdo_selected")) {
                        $(this).removeClass("rdo_selected");
                    } else {
                        $(this).addClass("rdo_selected");
                    }
                });

                var senderTel = '';
                senderTel = $("input[jsdo='senderTel']").val();
                if (senderTel != null && senderTel != '') {
                    var tel = senderTel.split('-');
                    $("input[jsdo='info_phone_country']").val(tel[0]);
                    $("input[jsdo='info_phone_area']").val(tel[1]);
                    $("input[jsdo='info_phone_num']").val(tel[2]);
                }
                var errorMsg = '';
                if ('' != '' || true == '') {
                    alert('');
                }
            });
            function createTel() {
                var telCountry = $("input[jsdo='info_phone_country']").val();
                var telArea = $("input[jsdo='info_phone_area']").val();
                var telNum = $("input[jsdo='info_phone_num']").val();
                if (telCountry != null && telCountry != '' && telArea != null && telArea != '' && telNum != null && telNum != '') {
                    var tel = telCountry + '-' + telArea + '-' + telNum;
                    $("#send_tel").val(tel);
                }
            }
            //联系人start----------------------------
            $(".sel_send").click(function () {
                var type = $("#ctype").val()
                $(".linkers_box :radio:checked").each(function (i, dom) {
                    $.post('/front/topContracts/getContract.json', {id: $(this).val()}, function (datas) {
                        for (var i in datas.msg) {
                            var d = datas.msg[i];
                            datas.msg[i] = !!d ? d : "";
                        }
                        if (datas.success) {
                            var data = datas.msg;
                            if (type == 0) {
                                $('#sendCom').val(data.comName);
                                $('#sendBy').val(data.contract);
                                $('#sendMobile').val(data.mobile);
                                $('#sendMail').val(data.email);
                                $('#outfromTextNew').val(data.provinceName + "," + data.cityName + "," + data.countyName);
                                $('input[jsdo="outfromArea_provinceName"]').val(data.provinceName);
                                $('input[jsdo="outfromArea_cityName"]').val(data.cityName);
                                $('input[jsdo="outfromArea_disName"]').val(data.countyName);
                                $('#sendAddr').val(data.addr);
                                if (!!data.tel && data.tel.indexOf("-") > 0) {
                                    var tels = new Array();
                                    tels = data.tel.split('-');
                                    if (tels.length == 3) {
                                        $("#sendCno").val(tels[tels.length - 3]);
                                    }
                                    $("#sendAreano").val(tels[tels.length - 2]);
                                    $("#sendTel").val(tels[tels.length - 1]);
                                } else {
                                    $("#sendAreano").val('');
                                    $("#sendTel").val('');
                                }
                                $('#baoMobile').val(data.mobile ? data.mobile : data.tel);
                            } else if (type == 1) {
                                $("#outToTexte").val(data.countryNameEn);
                                $('#receiverCom').val(data.comName);
                                $('#receiverName').val(data.contract);
                                $('#receiverProvinceName').val(data.provinceName);
                                $('#receiverCityName').val(data.cityName);
                                $('#receiverAddr').val(data.addr);
                                $('#receiverMail').val(data.email);
                                $('#receiverTel').val(data.tel);
                                $('#receiverMobile').val(data.mobile);
                                $('#receiverZip').val(data.zip);
                                if ("false") {
                                    isPianyuan(true);
                                }
                            } else if (type == 2) {
                                //保险选择联系人
                                $('#baoMobile').val(data.mobile);
                            }
                        }
                    }, "json");

                });
                $(".linkers_box").hide();
            });

            $(".sel_linker").click(function () {
                $("#ctype").val($(this).data("type"));
                $("#linkContent").empty();
                linker("#linkContent");
                $(".linkers_box").show();
                $(".linkers_box").find("#linkerInfoUrl").attr("href", "/front/topContracts/linkerInfo.html?ctype=" + $(this).attr("data-type"));
                $(".linkers_box .close_btn").click(function () {
                    $(".linkers_box").hide();
                });
            });//2016-03-31 new add 选择联系人btn   -----------end

            function linker(domId) {
                var ctype = $("#ctype").val();
                var cityName = "", countryName = "";
//      if(0==ctype){
//          cityName=$("input[name='sender.cityName']").val();
//      }else
                if (1 == ctype) {
                    countryName = $("input[name='countryName']").val();
                } else if (2 == ctype) {
                    ctype = 0;
                }
                if ($(domId).length > 0) {
                    $.ajax({
                        type: "POST",
                        url: "/front/topContracts/againFind.json",
                        data: {ctype: ctype, countryName: countryName, cityName: cityName},
                        dataType: "json",
                        async: false,
                        cache: false,
                        success: function (data) {
                            if (data.page.result.length >= 1) {
                                var contracts = data.page.result;
                                $.each(contracts, function (k, v) {
                                    for (var ki in contracts[k]) {
                                        var c = contracts[k][ki];
                                        contracts[k][ki] = !!c ? c : "";
                                    }
                                    var mobile, moren = "";
                                    var s = "", addr = "";
                                    if (null == contracts[k].mobile || "" == contracts[k].mobile) {
                                        mobile = contracts[k].tel;
                                    } else if (null == contracts[k].tel || "" == contracts[k].tel) {
                                        mobile = contracts[k].mobile;
                                    } else if ((null != contracts[k].mobile && null != contracts[k].tel) || ("" != contracts[k].mobile && "" != contracts[k].tel)) {
                                        mobile = contracts[k].mobile + "/" + contracts[k].tel;
                                    }
                                    if (1 == contracts[k].status) {
                                        moren = "默认";
                                        s = "checked";
                                    } else if (0 == contracts[k].status) {
                                        s = "";
                                    }
                                    if (0 == contracts[k].ctype) {
                                        if (null == contracts[k].cityName || "" == contracts[k].cityName) {
                                            addr = contracts[k].provinceName + contracts[k].addr;
                                        } else if (null == contracts[k].countyName || "" == contracts[k].countyName) {
                                            addr = contracts[k].provinceName + contracts[k].cityName + contracts[k].addr;
                                        } else {
                                            addr = contracts[k].provinceName + contracts[k].cityName + contracts[k].countyName + contracts[k].addr;
                                        }
                                    } else if (1 == contracts[k].ctype) {
                                        if (null == contracts[k].cityName || "" == contracts[k].cityName) {
                                            addr = contracts[k].addr + contracts[k].provinceName + contracts[k].countryNameEn;
                                        } else if (null == contracts[k].countyName || "" == contracts[k].countyName) {
                                            addr = contracts[k].addr + contracts[k].cityName + contracts[k].provinceName + contracts[k].countryNameEn;
                                        } else {
                                            addr = contracts[k].addr + contracts[k].countyName + contracts[k].cityName + contracts[k].provinceName + contracts[k].countryNameEn;
                                        }
                                    }
                                    $("#noContract").html("");
                                    $("#contractMsg").css("display", "block");
                                    if (0 == contracts[k].ctype) {
                                        $("#linkContent").append("<li style='text-align: center;margin-top:20px;' id='noContract'></li><li id='contractMsg'><label>" +
                                                "<div class='row1'><span class='linker_name' id='contract'>" + contracts[k].contract + "</span>" +
                                                "<span class='linker_tel' id='mobile'>" + mobile + "</span>" +
                                                "<span class='is_default' id='moren'>" + moren + "</span></div>" +
                                                "<div class='row2'><div class='address_info'><div id='comName'>" + contracts[k].comName + "</div>" +
                                                "<div id='addr'>" + addr + "</div></div>" +
                                                "<div class='is_default'><input type='radio' " + s + " id='status' data-id='' value='" + contracts[k].contractId + "'" + " name='rdo_group' /></div></div></label></li>");
                                    } else if (1 == contracts[k].ctype) {
                                        $("#linkContent").append("<li style='text-align: center;margin-top:20px;' id='noContract'></li><li id='contractMsg'> <label>" +
                                                "<div class='row1'><span class='linker_name' id='contract'>" + contracts[k].contract + "</span>" +
                                                "<span class='linker_tel' id='mobile'>" + mobile + "</span>" +
                                                "<span class='is_default' id='moren'>" + moren + "</span></div>" +
                                                "<div class='row2'><div class='address_info'><div id='comName'>" + contracts[k].comName + "</div>" +
                                                "<div id='addr'>" + addr + "</div></div>" +
                                                "<div class='is_default'><input type='radio' " + s + " id='status' data-id='' value='" + contracts[k].contractId + "'" + " name='rdo_group' /></div></div><label></li>");
                                    }

                                });
                            } else if (data.page.result.length == 0) {
                                if (cityName != "") {
                                    $("#linkContent").append("<li style='text-align: center;margin-top:20px;' id='noContract'></li><li id='contractMsg'>" + "您还未添加过<font color='red'>" + cityName + "</font>常用发件人！</li>");
                                } else if (countryName != "") {
                                    $("#linkContent").append("<li style='text-align: center;margin-top:20px;' id='noContract'></li><li id='contractMsg'>" + "您还未添加过<font color='red'>" + countryName + "</font>常用收件人！</li>");
                                }
                            }

                        }
                    });
                }
            }

            $(".show_hide").click(function () {
                $(".j_notice_bd_hover").slideToggle(800);
                $(".j_notice_bd").toggle();
                if ($(".j_notice_bd").is(":hidden")) {
                    $(this).html("收起▲");
                }
                else {
                    $(this).html("展开▼");
                }
            });//专线须知JS
        </script>

        <script type="text/javascript" src="${ctxStatic}/lutty/lutty.js"></script>
        <script type="text/javascript" src="${ctxStatic}/util/autoNumericUtil.js"></script>
        <script type="text/javascript" src="${ctxStatic}/util/autoNumeric.js"></script>
        <script type="text/javascript">
            $(function () {
                //申报金额只能输入两位小数点
                $("input[jsdo='wenum']").autoNumeric(AutoNumericUtils.getAmtConfig());

                //货物保险费用显示
                $('#insurance').blur(function () {
                    var insurance = $('#insurance').val() / 0.005;
                    var insuranceMsg = "货物总保险价值为:" + insurance + "元";
                    $('#msg').val(insuranceMsg);
                    $('#msg').show();
                })


//        买单报关
                $('#soleCd-pay').click(function () {
                    $('#msg').show();
                    $('#surcharge').val(100);
//            if(shipType == 7 && (specify == 3 || specify == 4 || specify == 5) ) {
                    $("#plf").attr("required", "required");
                    $("#dlf").attr("required", "required");
                    $("#form .next_step").removeAttr("pop-show");//修复当选择普通报关并触发下一步时,又修改报关类型直接跳过校验的问题
//            }
                });
//          普通报关
                $('#soleCd-common').click(function () {
                    $('#msg').hide();
                    $('#surcharge').val('');
//            if(shipType == 7 && (specify == 3 || specify == 4 || specify == 5) ) {
                    $("#plf").removeAttr("required");
                    $("#dlf").removeAttr("required");
                    $("#form .next_step").removeAttr("pop-show");//修复当选择普通报关并触发下一步时,又修改报关类型直接跳过校验的问题
//            }
                });
//        独立报关
                $('#soleCd-Indep').click(function () {
                    $('#msg').hide();
                    $('#surcharge').val('');
//            if(shipType == 7 && (specify == 3 || specify == 4 || specify == 5) ) {
                    $("#plf").attr("required", "required");
                    $("#dlf").attr("required", "required");
                    $("#form .next_step").removeAttr("pop-show");//修复当选择普通报关并触发下一步时,又修改报关类型直接跳过校验的问题
//            }
                });
                //报关方式--end

                //文件s上传 start
                $(".file").change(function () {

                    wordType = ["xls", "xlsx", "doc", "docx"];
                    if (this.value) {
                        if (!RegExp("\.(" + wordType.join("|") + ")$", "i").test(this.value.toLowerCase())) {
                            hdAlert.alert("选择文件错误,文档类型必须是" + wordType.join("，") + "中的一种");
                            this.value = "";
                            return false;
                        }
                    }
                    var path = $(this).val();
                    $(this).siblings('.upload').val(path);
                    return true;
                });//文件上传 end
            });
        </script>
    </form>
</div>
</body>
</html>