//== Class Definition
var UserSignIn = function() {

	var login = $('#m_login');

	var showErrorMsg = function(form, type, msg) {
		var alert = $('<div class="m-alert m-alert--outline alert alert-'
				+ type
				+ ' alert-dismissible" role="alert">\
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>\
			<span></span>\
		</div>');

		form.find('.alert').remove();
		alert.prependTo(form);
		alert.animateClass('fadeIn animated');
		alert.find('span').html(msg);
	}

	// == Private Functions

	var displaySignUpForm = function() {
		login.removeClass('m-login--forget-password');
		login.removeClass('m-login--signin');

		login.addClass('m-login--signup');
		login.find('.m-login__signup').animateClass('flipInX animated');
	}

	var displaySignInForm = function() {
		login.removeClass('m-login--forget-password');
		login.removeClass('m-login--signup');

		login.addClass('m-login--signin');
		login.find('.m-login__signin').animateClass('flipInX animated');
	}

	var displayForgetPasswordForm = function() {
		login.removeClass('m-login--signin');
		login.removeClass('m-login--signup');

		login.addClass('m-login--forget-password');
		login.find('.m-login__forget-password')
				.animateClass('flipInX animated');
	}

	var handleFormSwitch = function() {
		$('#m_login_forget_password').click(function(e) {
			e.preventDefault();
			displayForgetPasswordForm();
		});

		$('#m_login_forget_password_cancel').click(function(e) {
			e.preventDefault();
			displaySignInForm();
		});

		$('#m_login_signup').click(function(e) {
			e.preventDefault();
			displaySignUpForm();
		});

		$('#m_login_signup_cancel').click(function(e) {
			e.preventDefault();
			displaySignInForm();
		});
	}

	var handleSignInFormSubmit = function() {
		$('#m_login_signin_submit')
				.click(
						function(e) {
							e.preventDefault();
							var btn = $(this);
							var form = $(this).closest('form');

							form.validate({
								rules : {
									username : {
										required : true
									},
									password : {
										required : true
									}
								}
							});

							if (!form.valid()) {
								return;
							}

							btn.addClass(
									'm-loader m-loader--right m-loader--light')
									.attr('disabled', true);

							form
									.ajaxSubmit({
										url : '/signin',
										method : 'POST',
										success : function(response, status,
												xhr, $form) {

											if (response.code != 0) { // 登录失败，显示详细错误信息

												// 模拟 2 秒延时
												setTimeout(
														function() {
															btn
																	.removeClass(
																			'm-loader m-loader--right m-loader--light')
																	.attr(
																			'disabled',
																			false);
															showErrorMsg(form,
																	'danger',
																	'用户名或密码不正确，请重试。');
														}, 2000);
											} else {
//												console.log(response);
												console.log(status);
												console.log(xhr);
												console.log($form);
											}

											console.log(response);
										}
									});
						});
	}

	var handleSignUpFormSubmit = function() {
		$('#m_login_signup_submit')
				.click(
						function(e) {
							e.preventDefault();

							var btn = $(this);
							var form = $(this).closest('form');

							form.validate({
								rules : {
									fullname : {
										required : true
									},
									email : {
										required : true,
										email : true
									},
									password : {
										required : true
									},
									rpassword : {
										required : true
									},
									agree : {
										required : true
									}
								}
							});

							if (!form.valid()) {
								return;
							}

							btn.addClass(
									'm-loader m-loader--right m-loader--light')
									.attr('disabled', true);

							form
									.ajaxSubmit({
										url : '',
										success : function(response, status,
												xhr, $form) {
											// similate 2s delay
											setTimeout(
													function() {
														btn
																.removeClass(
																		'm-loader m-loader--right m-loader--light')
																.attr(
																		'disabled',
																		false);
														form.clearForm();
														form.validate()
																.resetForm();

														// display signup form
														displaySignInForm();
														var signInForm = login
																.find('.m-login__signin form');
														signInForm.clearForm();
														signInForm.validate()
																.resetForm();

														showErrorMsg(
																signInForm,
																'success',
																'感谢，请检查邮件来完成注册。');
													}, 2000);
										}
									});
						});
	}

	var handleForgetPasswordFormSubmit = function() {
		$('#m_login_forget_password_submit')
				.click(
						function(e) {
							e.preventDefault();

							var btn = $(this);
							var form = $(this).closest('form');

							form.validate({
								rules : {
									email : {
										required : true,
										email : true
									}
								}
							});

							if (!form.valid()) {
								return;
							}

							btn.addClass(
									'm-loader m-loader--right m-loader--light')
									.attr('disabled', true);

							form
									.ajaxSubmit({
										url : '',
										success : function(response, status,
												xhr, $form) {
											// similate 2s delay
											setTimeout(
													function() {
														btn
																.removeClass(
																		'm-loader m-loader--right m-loader--light')
																.attr(
																		'disabled',
																		false); // remove
														form.clearForm(); // clear
																			// form
														form.validate()
																.resetForm(); // reset
																				// validation
																				// states

														// display signup form
														displaySignInForm();
														var signInForm = login
																.find('.m-login__signin form');
														signInForm.clearForm();
														signInForm.validate()
																.resetForm();

														showErrorMsg(
																signInForm,
																'success',
																'密码恢复指令已发送到您的邮箱地址。');
													}, 2000);
										}
									});
						});
	}

	// == Public Functions
	return {
		// public functions
		init : function() {
			handleFormSwitch();
			handleSignInFormSubmit();
			handleSignUpFormSubmit();
			handleForgetPasswordFormSubmit();
		}
	};
}();

// == Class Initialization
jQuery(document).ready(function() {
	UserSignIn.init();
});