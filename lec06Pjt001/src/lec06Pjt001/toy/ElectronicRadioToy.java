package lec06Pjt001.toy;

import lec06Pjt001.battery.Battery;

public class ElectronicRadioToy {
	
	private Battery battery;
	
	//생성자를 이용해서도 하고 컨스럭트를 이용해서도 한다.
	
	//기본적으로 넣어두었다.
	public ElectronicRadioToy(Battery battery) {
		this.battery = battery;
	}
	
	//사용자가 원할때 한다.
	public void setBattery(Battery battery) {
		this.battery = battery;
	}
	
}