(function($){
    var isBegin = 0;                    //表示按钮状态：1：已经开始；0：已经停止；
    var isGoOn = 1;                      //用来标时代否循环执行滚动动画

    //转换字符串为数字数组
    function splitNum(num){
        var arr = num.split("");
        for(var i = 0; i< arr.length; i++){
            arr[i]-='0';
        }
        return arr;
    }

    $('#btn').click(function(){
        if(isBegin === 0){                 //如果没开始则开始抽奖；
            $(".info").text("");
            isGoOn =1;
            $("#btn").text("停止抽奖");       //将提示符变为停止抽奖
            $(".number").each(function(index){//设置每一个数字开始滚动
                var _number = $(this);
                startAnimate();
                function startAnimate(){
                    if(isGoOn == 1)
                        _number.animate({backgroundPositionY:"-=265px"}, { duration: 50+index*10,easing:'linear',complete:startAnimate});
                }
            });
            isBegin = 1;                  //将状态设置为已开始
        }else if(isBegin === 1){        //如果已开始则停止抽奖
            $.ajax({                      //发送ajax请求获取学号信息
                // url: 'http://127.0.0.1/join/lottery.php',
                url: 'lottery.do',
                success: function(recv){
                    var data = $.parseJSON(recv);
                    console.log(data);
                    var arr = splitNum(data.sid);
                    $(".number").each(function(index){//设置每一个数字开始滚动
                        var _number = $(this);
                        _number.animate({backgroundPositionY:arr[index]*(-265)},{ duration: 50+index*1000,easing:'linear', complete:show});
                        function show(){        //当最后一个动画结束的时候显示获奖人信息
                            if(index == 7){
                                $(".info").html("恭喜"+"<b id='name'>"+data.name+"</b>"+"获得本次奖品");
                            }
                        }
                    });
                    isBegin = 0;
                    isGoOn = 0;
                    $("#btn").text("开始抽奖");
                }
            });
        }
    });
})(window.jQuery);