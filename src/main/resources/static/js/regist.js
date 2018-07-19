	
	$(function() {
		//1.遍历所有错误信息集合，调用showError方法确定是否显示作物信息
		$(".text-error").each(function(){
			showError($(this));//遍历每一个元素，判断装载错误信息的span是否显示
		});
		//2.输入框得到焦点，隐藏错误信息
		$(".input-field").focus(function(){
			var spanId = $(this).attr("id")+"Error";//得到显示错误信息的span的id
			$("#"+spanId).text("");//将错误信息清空
			showError($("#"+spanId));//把元素隐藏掉
		});
		
		//3.输入框失去焦点
		$(".input-field").blur(function(){
			var name = $(this).attr("name");//获取当前元素的id
			var funName = "validate"+name.substring(0,1).toUpperCase()+name.substring(1)+"()";//对应校验方法名
			eval(funName);//eval将字符串变为可执行代码运行，即调用该方法
		});
		//4.提交
		
		
	});

	function showError(ele){
		var text = ele.text();
		if(!text){//错误信息为空，则span不显示
			ele.css("display","none");
		}else{
			ele.css("display","");//默认显示
		}
	};

	//邮箱的校验
	function validateEmail(){
		var id="email";
		//校验非空
		var value=$("#" + id).val();//获取输入框内容
		if(!value){
			$("#emailError").text("email不能为空！");
			showError($("#"+id+"Error"));
			return false;
		}
		//email格式校验
		if(!/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/.test(value)){
			$("#"+id+"Error").text("email格式错误！");
			showError($("#"+id+"Error"));
			return false;
		}
		//通过校验，返回true
		return true;
	}

	//昵称的校验
	function validateUserName(){
		var id="userName";
		//校验非空
		var value=$("#" + id).val();//获取输入框内容
		if(!value){
			$("#"+id+"Error").text("昵称不能为空！");
			showError($("#"+id+"Error"));
			return false;
		}
		//username长度校验
		if(value.length<3||value.length>20){
			$("#"+id+"Error").text("昵称的长度必须在3~20之间!");
			showError($("#"+id+"Error"));
			return false;
		}
		return true;
	}

	//密码的校验
	function validateUserPwd(){
		var id="userPwd";
		//校验非空
		var value=$("#" + id).val();//获取输入框内容
		if(!value){
			$("#"+id+"Error").text("密码不能为空！");
			showError($("#"+id+"Error"));
			return false;
		}
		//userPWd长度校验
		if(value.length<6||value.length>20){
			$("#"+id+"Error").text("密码的长度必须在6~20之间!");
			showError($("#"+id+"Error"));
			return false;
		}
		return true;
	}

	//确认密码的校验
	function validateConfirmPwd(){
		var id="confirmPwd";
		//校验
		var value=$("#" + id).val();//获取输入框内容
		if(!value){
			$("#"+id+"Error").text("确认密码不能为空！");
			showError($("#"+id+"Error"));
			return false;
		}
		if(value!=$(".input-field[name='userPwd']").val()){
			$("#"+id+"Error").text("两次密码不一致！");
			showError($("#"+id+"Error"));
			return false;
		}
		return true;
	}

	//验证码的校验
	function validateVerifyCode(){
		var id="verifyCode";
		//校验
		var value=$("#" + id).val();//获取输入框内容

		if(!value){
			$("#"+id+"Error").text("验证码不能为空！");
			showError($("#"+id+"Error"));
			return false;
		}
		if(value.length!=5){
			$("#"+id+"Error").text("验证码错误！");
			showError($("#"+id+"Error"));
			return false;
			alert(value);
		}
		//ajax验证码校验
		/*
		$.ajax({
			//7大参数
			url:"/engineer/UserServlet",//要请求的servlet
			data:{method:"ajaxValidateVerifyCode",verifyCode:value},//给服务器的参数
			type:"POST",
			dataType:"json",
			async:false,//是否异步请求，如果是异步请求，则不等服务器返回，我们这个函数就直接向下运行
			cache:false,
			success:function(result){
				if(!result)
					{
						$("#"+id+"Error").text("验证码错误！");
						showError($("#"+id+"Error"));
						return false;
					}
			}
		});*/
		//要通过检验，
		return true;
	}


	
