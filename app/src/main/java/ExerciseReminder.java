public class ExerciseReminder extends Reminder
{
    private String[] recommendedList = {"Stretch", "Do sit-ups", "Do push-ups", "Lift weights", "Go for a run"};
    public ExerciseReminder()
    {
        super();
    }
    public ExerciseReminder(String toDo, float timeToDo)
    {
        super(toDo, timeToDo);
    }

    public String[] getList()
    {
        return recommendedList;
    }
}
