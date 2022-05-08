package spring.di.ui;

import spring.di.entity.Exam;

public class InlineExamConsle implements ExamConsole {
	
	private Exam exam;
	
	public InlineExamConsle() {
		// TODO Auto-generated constructor stub
	}
	
	public InlineExamConsle(Exam exam) {
		this.exam = exam;
	}

	@Override
	public void print() {
		System.out.printf("titol is %d, avg is &f\n", exam.total(), exam.avg());
		

	}
	
	@Override
	public void setExam(Exam exam) {
		this.exam = exam;
		
	}

}
