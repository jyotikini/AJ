$(document).ready(
		
		
		function()
		{
			var i=0;
				$("#reports-section-plus").click(function()
				{
					/*if(i%)*/
					$("#reports-section-minus").css("display","block");
					$("#reports-section-hori").css("display","block");
					$("#reports-section-plus").css("display","none");
					//i=i+1;
				});
				$("#reports-section-minus").click(function()
						{
							/*if(i%)*/
							$("#reports-section-plus").css("display","block");
							$("#reports-section-hori").css("display","none");
							$("#reports-section-minus").css("display","none");
							//i=i+1;
						});
				
				$("#achievements-section-plus").click(function()
						{
							/*if(i%)*/
							$("#achievements-section-minus").css("display","block");
							$("#achievements-section-hori").css("display","block");
							$("#achievements-section-plus").css("display","none");
							//i=i+1;
						});
				$("#achievements-section-minus").click(function()
						{
									/*if(i%)*/
							$("#achievements-section-plus").css("display","block");
							$("#achievements-section-hori").css("display","none");
							$("#achievements-section-minus").css("display","none");
									//i=i+1;
						});
				$("#trainings-section-plus").click(function()
						{
							/*if(i%)*/
							$("#trainings-section-minus").css("display","block");
							$("#trainings-section-hori").css("display","block");
							$("#trainings-section-plus").css("display","none");
							//i=i+1;
						});
				$("#trainings-section-minus").click(function()
						{
									/*if(i%)*/
							$("#trainings-section-plus").css("display","block");
							$("#trainings-section-hori").css("display","none");
							$("#trainings-section-minus").css("display","none");
									//i=i+1;
						});


				

});