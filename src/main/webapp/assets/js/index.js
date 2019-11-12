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
