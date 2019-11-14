var move={
    liner:function (c,t,d,b) {
        return b+c*t/d
    },
    easein:function (c,t,d,b) {
        return b+c*(t/=d)*t
    },
    easeout:function (c,t,d,b) {
        return b-c*(t/=d)*(t-2)
    }
}

function animate2(obj,attrObj,time1,fun1,callback1){
    var start=[],end=[],val=[],c=[],t=0
    if(arguments.length==2){
        var time=1000;
        var fun="liner"
        var callback=null
    }
    if(arguments.length==3){
        if(typeof arguments[2]=="number"){
            var time=arguments[2];
            var fun="liner"
            var callback=null
        } else if( typeof arguments[2]=="string"){
            var time=2000;
            var fun=arguments[2];
            var callback=null
        }
        else if( typeof arguments[2]=="function"){
            var time=2000;
            var fun="liner";
            var callback=arguments[2]
        }
    } else if(arguments.length==4){
        if(typeof arguments[3]=="string"){
            var time=arguments[3];
            var fun=fun1
            var callback=null
        }else if(typeof arguments[3]=="function"){
            var time=arguments[3];
            var fun="liner"
            var callback=callback1
        }
    }

    for(var i in attrObj){
        start[i]=parseInt(getComputedStyle(obj,null)[i]) ?parseInt(getComputedStyle(obj,null)[i]):0
        end[i]=attrObj[i]
        c[i]=end[i]-start[i]
    }

    var t1=setInterval(function () {
        t+=40
        for(var i in attrObj){
            val[i]=move[fun](c[i],t,time,start[i])
        }
        if(t>=time){
            clearInterval(t1)
            for(var i in attrObj){
                if(i=="opacity"){
                    val[i]=end[i]
                }else {
                    val[i]=end[i] +"px"
                }

            }
            if(callback){
                callback()
            }
        }
        for(var i in attrObj){
            if(i=="opacity"){
                obj.style[i]=val[i]
            }
            else {
                obj.style[i]=val[i]+"px"
            }

        }

    },40)
}
function tabs(selector1,selector2) {
    var links=document.querySelectorAll(selector1)
    var list=document.querySelectorAll(selector2)
    for(let i=0;i<links.length;i++){
        links[i].onclick=function () {
            for(let j=0;j<list.length;j++){
                list[j].style.display="none"
                links[j].style.backgroundColor=""
            }
            list[i].style.display="block"
            this.style.backgroundColor="#D0DAE0"
        }
    }
}
window.onload=function () {
    console.log(3)
    var num=0;
    var boxs=document.querySelectorAll(".main-img-container-xj .img-container-xj")
    var box=document.querySelectorAll(".img-container-xj")
    function move() {
        num++
        if(num>1) {
            num = 0
        }

        for(var i=0;i<boxs.length;i++){
            boxs[i].style.opacity=0
        }
        animate2(boxs[num], {opacity:1})
        box.onmouseover=function(){
            clearInterval(t)
        }
        box.onmouseout=function(){
            t=setInterval(move,2000)
        }
        window.onblur=function () {
            clearInterval(t)
        }
        window.onfocus=function () {
            //在屏幕失去焦点的时候，里面的内容是不实时渲染的，
            //
            t=setInterval(move,2000)
        }
    }
    var t=setInterval(move,2000)


    tabs(".search-header-li-xj",".search-bottom-xj")

}



$("#signupForm").validate({
    rules: {
    
      name: {
        required: true,
        minlength: 2,
        maxlength:10
      },
      password: {
        required: true,
        minlength: 5
      },
      confirm_password: {
        required: true,
        minlength: 5,
        equalTo: "#password"
      },
      sex:{
    	  required: true,
      },
      age:{
    	  required: true,
      },
      address:{
    	  required: true,
      },
      phone:{
    	  required: true,
    	  minlength: 5,
    	  number:true,
    	  remote:{
    		  url:"yZreg",
    		  data:{phone: function(){return $("#phonenum").val()}},
    		 
    	  },
    	 
    	
      }
      
    },
    
    messages: {
    	name: {
        required: "请输入用户名",
        minlength: "用户名必需由两个字符组成",
        maxlength: "密码长度不能大于 10 ",
      },
      password: {
        required: "请输入密码",
        minlength: "密码长度不能小于 5 个字母"
      },
      confirm_password: {
        required: "请输入密码",
        minlength: "密码长度不能小于 5 ",
        equalTo: "两次密码输入不一致"
      },
      sex:{
    	  required: "请选择性别",
      },
      age:{
    	  required: "请选择生日",
      },
      address:{
    	  required: "请填写地址",
      },
      phone:{
    	  required: "请填手机号",
    	  minlength: "手机长度不能小于 5 个数字",
    	  number:"请输入合法的数字",
    	  remote:"手机号已被注册",
      }
      
     }
    
    })
   
    
    $("#login").validate({
    rules: {
    
    	userNum: {
        required: true,
        remote:{
  		  url:"yZphone",
  		  data:{phone: function(){return $("#uPhone").val()}},
  		 
  	      },
  	  
    },
   	userPass: {
        required: true,
    },
     
      
    },
    
    messages: {
    	userNum: {
        required: "请输入用户名",
        remote:"用户名不存在"
      },
      userPass:{
          required: "请输入密码",
          
        },
     
     }
    
    })
