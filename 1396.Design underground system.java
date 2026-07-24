import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {
    
    private Map<Integer, CheckInInfo> checkIns;
    
    
    private Map<String, TripData> routeData;

    private static class CheckInInfo {
        String stationName;
        int time;

        CheckInInfo(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }

    private static class TripData {
        double totalTime;
        int tripCount;

        TripData(double totalTime, int tripCount) {
            this.totalTime = totalTime;
            this.tripCount = tripCount;
        }
    }

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        routeData = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInInfo(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckInInfo info = checkIns.remove(id);
        String routeKey = info.stationName + "->" + stationName;
        int travelTime = t - info.time;

        TripData trip = routeData.getOrDefault(routeKey, new TripData(0, 0));
        trip.totalTime += travelTime;
        trip.tripCount++;
        routeData.put(routeKey, trip);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        TripData trip = routeData.get(routeKey);
        return trip.totalTime / trip.tripCount;
    }
}
