package todolist;

public class Model_ToDoList {
	private Integer id;
	private String task;
	private String date;
	private String status;
	private String date_completed;

	public Model_ToDoList() {
		super();
	}

	public Model_ToDoList(Integer id, String task, String status) {
		super();
		this.id = id;
		this.task = task;
		this.date = date;
		this.status = status;

	}

	public Model_ToDoList(Integer id, String task, String date, String status, String date_completed) {
		super();
		this.id = id;
		this.task = task;
		this.date = date;
		this.status = status;
		this.date_completed = date_completed;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDate_completed() {
		return date_completed;
	}

	public void setDate_completed(String date_completed) {
		this.date_completed = date_completed;
	}
	

}