function checkFormatDate(day) {
			if(day.length!=10){
				return false;
			}
			date=day.slice(0,2);
			character1=day.slice(2,3);
			month=day.slice(3,5);
			character2=day.slice(5,6);
			year=day.slice(6);
			if((typeof date)==="number"||(typeof month)==="number"||(typeof year)==="number"||character1!="/"||character2!="/") {
				return false;
			}
			if(year<2016||year>2020){
				return false;
			} else if((date < 1) || (month < 1) || (month > 12)){
				return false;
			} else {
				switch(month) {
				case "01":
				case "03":
				case "05":
				case "07":
				case "08":
				case "10":
				case "12":
					if(date>31) {
						return false;
					} else {
						return true;
					}
				case "02":
					if((year%4==0)&&(year%100!=0)){
						if(date>29) {
							return false;
						} else {
							return true;
						}
					} else {
						if(date>28) {
							return false;
						} else {
							return true;
						}
					}
				case "04":
				case "06":
				case "09":
				case "11":
					if(date>30) {
						return false;
					} else {
						return true;
					}
				}
			}
			return false;
		}