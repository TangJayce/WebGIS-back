var RootPath;     //根路径
var flag;         //标记，用来判断
//密码正则表达式：字母+数字，字母+特殊字符，数字+特殊字符(有且只有两项)
// var password_pattern = /^(?![a-zA-z]+$)(?!\d+$)(?![!@#$%^&*]+$)[a-zA-Z\d!@#$%^&*]+$/;
var is_right_name = false;

$(function () {
    RootPath = $("#RootPath").val();

    //导航栏切换显示
    $('.menu.toggle').click(function () {
        $('.m-hide').toggleClass('m-mobile-hide');
    });

    //提示信息的关闭事件
    $('.message .close')
        .on('click', function() {
            $('.message.success').hide();
            $('.message.negative').hide();
        })
    ;

    //更多信息填写框的显示切换
    $('.ui.accordion')
        .accordion()
    ;

    //点击显示密码
    $('.myPasswordIcon').click(function () {
        $(":password").attr("type","text");
    });

    //注册框的失去焦点事件，判断是否存在该用户名
    $('#register_name_div').blur(function () {
        //获取文本框的值
        var register_name = $(this).val();
        if(register_name == "" || $.trim(register_name).length == 0){
            //如果用户名为空
            is_right_name = false;
            $('.check.circle.icon').hide();
            show_register_error($('#userExist_error'),"用户名不能为空");
        }else {
            //通过ajax异步发送post请求
            $.post(RootPath + "/CheckNameServlet", //发送请求的路径
                {register_name: register_name},    //发送的数据
                function (data) {                  //回调函数
                    if (data.userExsit) {
                        //用户名存在(已被占用)
                        is_right_name = false;
                        $('.check.circle.icon').hide();
                        show_register_error($('#userExist_error'),data.msg);
                    } else {
                        //用户名不存在(用户名可用)
                        is_right_name = true;
                        $('.check.circle.icon').show();
                        hide_register_error($('#userExist_error'));
                    }
                },
                "json"  //返回的数据类型
            );
        }
    });

    //密码框的失去焦点事件
    // $('#register_password_input').blur(function () {
    //     if(checkPassword()){
    //         hide_register_error($(this));
    //         is_right_password = true;
    //     }else {
    //         is_right_password = false;
    //         show_register_error($(this),"密码格式错误，必须包含字母、数字、特殊字符中的两项");
    //     }
    // });

    //注册表单的提交
    // $("#register_form").submit(function () {
    //     // alert("提交表单");
    //     //先校验再提交
    //     return checkCode();
    // });

});

//显示注册错误信息
function show_register_error(error_div,text) {
    error_div.addClass("error");
    $("#register_error_div").show();
    $("#register_error_msg").html(text);
}

//隐藏注册错误信息
function hide_register_error(error_div) {
    error_div.removeClass("error");
    $("#register_error_div").hide();
}

//点击显示登陆界面
function login() {
    $("[name='user_password']").attr("type","password");
    $("[name='register_password']").attr("type","password");
    $('#login_div')
        .modal({
            blurring: true
        })
        .modal('show')
    ;
}

//点击显示注册页面
function register() {
    $("[name='user_password']").attr("type","password");
    $("[name='register_password']").attr("type","password");
    $('#register_div')
        .modal({
            blurring: true
        })
        .modal('show')
    ;
}

//点击验证码图片切换图片
function refreshCheckCode() {
    var date = new Date().getTime();
    $("#CheckCode").attr('src',RootPath + "/CheckCode?" + date);
}

//校验密码
// function checkPassword() {
//     var password = $('#register_password_input').val();
//     return password_pattern.exec(password);
// }

//校验表单
function checkForm() {
    //alert("提交表单.........");
    //先校验再提交
    if(is_right_name ) {
        var check_code = $('#check_code_input').val();
        // alert("check_code = " + check_code);
        $.post(RootPath + "/CheckCodeServlet",  //发送请求的路径
            {check_code: check_code},           //发送的数据
            function (data) {                   //回调函数
                if (data.check_right) {
                    //验证码正确
                    hide_register_error($('#check_code_error_div'));
                    $('#register_form').submit();
                } else {
                    //验证码错误
                    show_register_error($('#check_code_error_div'),data.msg);
                    refreshCheckCode();
                }
            },
            "json"  //返回的数据类型
        );
    }
}