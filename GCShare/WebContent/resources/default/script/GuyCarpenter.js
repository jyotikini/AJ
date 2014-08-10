$(document)
		.ready(

				function() {
					var i = 0;
					$(".reports-n-achievements-n-trainings-toggle-button")
							.click(
									function() {
										var button_id = $(this).attr('id');
										var a = button_id.split("-");
										var button_text_append = a[0] + "-"
												+ a[1];
										var current_status = $(
												"#" + button_text_append
														+ "-minus").css(
												"display");
										var hori_color = $(
												"#" + button_text_append
														+ "-hori").css(
												"background-color");
										if (current_status == "none") {// display
											// hori
											// section
											$(
													".reports-n-achievements-n-trainings-toggle-button-minus")
													.css("display", "none");
											$(
													".reports-n-achievements-n-trainings-toggle-button-plus")
													.css("display", "block");
											$(
													"#" + button_text_append
															+ "-plus").css(
													"display", "none");
											$(
													"#" + button_text_append
															+ "-minus").css(
													"display", "block");
											$(
													"#" + button_text_append
															+ "-hori").css(
													"display", "block");
											$(
													"#" + button_text_append
															+ "-hori")
													.siblings().css("display",
															"none");
											/*
											 * $(".reports-n-achievements-n-trainings-individual-box-verti")
											 * .css("background-color",
											 * "transparent"); $( "#" +
											 * button_text_append +
											 * "-verti").css(
											 * "background-color", hori_color);
											 */
											$(
													"#" + button_text_append
															+ "-plus").css(
													"display", "none");
										} else if (current_status == "block") {// hide
											// hori
											// section
											$(
													".reports-n-achievements-n-trainings-toggle-button-minus")
													.css("display", "none");
											$(
													".reports-n-achievements-n-trainings-toggle-button-plus")
													.css("display", "block");
											$(
													"#" + button_text_append
															+ "-minus").css(
													"display", "none");
											$(
													"#" + button_text_append
															+ "-plus").css(
													"display", "block");
											$(
													"#" + button_text_append
															+ "-hori").css(
													"display", "none");
											$(
													"#" + button_text_append
															+ "-hori")
													.siblings().css("display",
															"none");
											/*
											 * $(".reports-n-achievements-n-trainings-individual-box-verti")
											 * .css("background-color",
											 * "transparent"); $( "#" +
											 * button_text_append +
											 * "-verti").css(
											 * "background-color", hori_color);
											 */
											$(
													"#" + button_text_append
															+ "-minus").css(
													"display", "none");
										}

									});

				});