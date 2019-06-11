/*$(document).ready(
		function() {
			function username() {
				var username = $("#username").val();

				if (username == null || username.length <= 0) {

					$("#username").next().remove();

					$("#username").after(
							"<span class='text-danger'>用户名为空,请填写用户名</span>");

					return false;

				}

				return true;

			}

			function password() {
				var password = $("#example-password-input").val();

				if (password == null || password.length <= 0) {

					$("#example-password-input").next().remove();

					$("#example-password-input").after(
							"<span class='text-danger'>密码为空,请输入密码</span>");

					return false;

				}

				return true;
			}
		});*/

function usernames() {
	var username = $("#username").val();

	if (username == null || username.length <= 0) {

		$("#username").next().remove();

		$("#username").after("<span class='text-danger'>用户名为空,请填写用户名</span>");

		return false;

	}

	return true;

}

function passwords() {
	var password = $("#example-password-input").val();

	if (password == null || password.length <= 0) {

		$("#example-password-input").next().remove();

		$("#example-password-input").after(
				"<span class='text-danger'>密码为空,请输入密码</span>");

		return false;

	}

	return true;
}

$(".login").click(
		function() {

			var username = $("#username").val();

			var password = $("#example-password-input").val();

			console.log(usernames() == true);

			console.log(passwords() == true);

			// 检查用户名和密码
			if (usernames() == true && passwords() == true) {

				var url = /* window.location.host + */"/user/login?name="
						+ username + "&password=" + password
				console.log("url:" + url);

				$.ajax({
					type : "GET",
					dataType : "json",
					url : url,
					success : function(data) {
						console.log(data);
						if (data.result == "SUCCEED") {
							
							window.location.href = "/page/tables.html";
							toastr.success(data.info);

						} else {
							toastr.error(data.info);
						}
					}
				})

			}

		});

$("#username").blur(function() {
	return usernames();

});

$("#example-password-input").blur(function() {
	return passwords();

});
