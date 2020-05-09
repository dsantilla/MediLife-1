public abstract class Reminder
{
    private boolean onScreen = false;
    private boolean completed = false;
    private String task;
    private float time;
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

    public void setCompleted(boolean status)
    { completed = status; }

    public void setOnScreen(boolean status)
    { onScreen = status; }

    public String getTask()
    {  return task;    }

    public float getTime()
    { return time; }

    public boolean getOnScreen()
    {  return onScreen;    }

    public boolean getCompleted()
    { return completed; }

    public abstract String[] getList();

}