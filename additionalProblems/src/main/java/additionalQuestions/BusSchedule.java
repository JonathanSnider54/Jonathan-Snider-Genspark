package additionalQuestions;

public class BusSchedule {
    public static int maxPlatform(float[] arr, float[] dep) {

        int currentPlatforms = 0;
        int maxPlatforms=0;
        int trainsArrived = 0;
        int trainsLeft = 0;
        while (trainsLeft < dep.length && trainsArrived < dep.length)
        {
            if (arr[trainsArrived] < dep[trainsLeft])
            {
                trainsArrived++;
                currentPlatforms++;
            }
            else
            {
                trainsLeft++;
                currentPlatforms--;
            }
            if(currentPlatforms>maxPlatforms)
            {
                maxPlatforms=currentPlatforms;
            }
        }
return maxPlatforms;
    }
}
