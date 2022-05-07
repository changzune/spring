package spring.di.ui;

import spring.di.entity.Exam;

public class InlineExamConsle implements ExamConsole {
	
	private Exam exam;
	
	
	public InlineExamConsle(Exam exam) {
		this.exam = exam;
	}

	@Override
	public void print() {
		System.out.println();
		

	}

}
