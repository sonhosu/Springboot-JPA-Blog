let index = {
	init: function() {
		$("#btn-save").on("click", () => {
			this.save();
		});
	},

	save: function() {
		//alert('user의save함수 호출됨');
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			eamil: $("#email").val()
		}
		//console.log(data);			로그인 정보가 잘오는지 확인하는방법  f12 콘솔보기
		
		
		$.ajax().done().fail(); // ajax통신을 이용해서 3개의 데이터를 json 으로 변경하여 insert요청!
	}

}


index.init();