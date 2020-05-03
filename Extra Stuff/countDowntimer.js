function countDown(time){
	var intervalId = setInterval(function(){
		console.log(time);
		time-=1000;
		if(time===0)
			clearInterval(intervalId);
	}, 1000);
}