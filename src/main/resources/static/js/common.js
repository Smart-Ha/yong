function getDate(type) {
    //type = 1,日期2017-10-12, type=2,2017-10-12 19:12
    var myDate = new Date();
    //获取当前年
    var year=myDate.getFullYear();
    //获取当前月
    var month=myDate.getMonth()+1;
    //获取当前日
    var date=myDate.getDate();
    if(type = 1){
        return year+'-'+ month+'-'+date;
    }
    var h=myDate.getHours();
    var m=myDate.getMinutes();
    var s = myDate.getSeconds();
    return  year+'-'+ month+'-'+date+' '+h+':'+m+':'+s;
}

function change() {
    $("#vCode").attr("src","/verifyCode?a=" + new Date().getTime());
}