let index = {
	init: function() {
		$("#btn-save").on("click", () => { //function(){} 대신 ()=> 를 사용하는 이유는 this 를 바인딩하기위해서
			this.save();
		});
	},

	save: function() {
		//alert('user의save함수 호출됨');
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			eamil: $("#email").val()
		};
		//console.log(data);			로그인 정보가 잘오는지 확인하는방법  f12 콘솔보기


		//ajax호출시 default가 비동기 호출
		// ajax통신을 이용해서 3개의 데이터를 json 으로 변경하여 insert요청!
		//회원가입 수행을 요청
		$.ajax({
			type: "POST",
			url: "/blog/api/user",
			data:JSON.stringify(data), //http body 데이터
			contentType:"application/json; charset=utf-8", //body데이터가 어떤 타입인지
			dataType:"json"//		
		
		}).done(function(resp) {
			alert("회원가입이 완료되었습니다.");
			console.log(resp);
			location.href="/blog";
			
		
		}).fail(function(error) {
			alert(JSON.stringify(error));
			

		});




	}

}


index.init();