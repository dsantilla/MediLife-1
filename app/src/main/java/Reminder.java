public abstract class Reminder
{

    private boolean status = false;
    private String task;
    private float time;
    private String[] recommendedList = new String[5];
    private int listLength = 0;

    public Reminder()
    {
        task = "";
        time = 0;
    }
    public Reminder(String toDo, float timeToDo)
    {
        task = toDo;
        time = timeToDo;
    }
    public void setTask(String toDo)
    {  task = toDo; }

    public void setTime(float timeToDo)
    {  time = timeToDo; }

    public void setStatus(boolean completed)
    { status = completed; }

    public String getTask()
    {  return task;    }

    public float getTime()
    { return time; }

    public boolean getStatus()
    { return status; }

    public String[] getList()
    { return recommendedList; }

}