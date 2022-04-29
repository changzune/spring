package lec06Pjt001.toy;

import lec06Pjt001.battery.Battery;

public class ElectronicRobotToy {
	
	private Battery battery;
	
	public ElectronicRobotToy() {
		//생성자에서 메인매소드를 생성을 하면 껍데기만 만들어준다.
		//내가 원하는 배터리르 세터를 이용하여 넣은 후 다시한다.
	}
	
	public void setBattery(Battery battery) {
		this.battery = battery;
	}
	
}