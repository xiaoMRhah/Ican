<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>微信支付小测试</title>
<script src="js/fingerprint2.min.1.4.1.js"></script>
<script src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
	<section class="content">
	<h2>商品：小瓢虫</h2>
	<ul class="select cf">
		<li><img src="img/piaochong.jpg"
			style="width: 150px; height: 150px"></li>
	</ul>
	<p class="copy-right">此商品易飞，若未收到商品，说明商品已经飞走!</p>
	<div class="price">
		"瓢虫价格：" <strong>￥0.01元</strong>
	</div>
	<div class="operation">
		<button class="btn-green" id="getBrandWCPayRequest">立即购买</button>
	</div>
	</section>



	<script type="text/javascript">
		$("#getBrandWCPayRequest").click(
				function() {
					/* $.ajax({
						type:'POST',
						url:,
						data:,
						success:success,
						dataType:dataType
					}); */
					function onBridgeReady() {
						WeixinJSBridge.invoke('getBrandWCPayRequest', {
							"appId" : ${appid}, //公众号名称，由商户传入
							"timeStamp" : ${timestamp}, //时间戳，自1970年以来的秒数
							"nonceStr" : ${nonceStr}, //随机串
							"package" : ${package1}, //预支付交易会话标识
							"signType" : ${signType}, //微信签名方式
							"paySign" : ${paySign}, //微信签名
						}, function(res) {
							if (res.err_msg == "get_brand_wcpay_request:ok") {
								alert("支付成功");
							}else if(res.err_msg=="get_brand_wcpay_request:cancel"){
								alert("支付取消");
							}else if(res.err_msg=="get_brand_wcpay_request:fail"){
								alert("支付失败");
							}
							//使用以上方式判断前端返回，微信团队郑重提示：res.err_msg将在用户支付成功
							//后返回ok，但并不保证它绝对可靠
						});
					}

				});
	</script>
</body>
</html>