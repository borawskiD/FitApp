package pl.borawski.fitapp.panel;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.borawski.fitapp.data.HealthDataEntity;
import pl.borawski.fitapp.data.HealthDataRepository;
import pl.borawski.fitapp.user.User;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class UserPanelService {
    HealthDataRepository healthDataRepository;

    public UserPanelService(HealthDataRepository healthDataRepository) {
        this.healthDataRepository = healthDataRepository;
    }

    @Transactional
    public UserSummaryDTO testMethod(User user) {
        //    public HealthDataEntity(double weight, double height, String gender, String activityLevel, LocalDateTime updateDate, User user) {
        healthDataRepository.save(new HealthDataEntity(100, 180, "M", "3", LocalDateTime.now().minusDays(9), user));
        healthDataRepository.save(new HealthDataEntity(102, 190, "M", "1", LocalDateTime.now(), user));
        healthDataRepository.save(new HealthDataEntity(99, 185, "M", "2", LocalDateTime.now(), user));
        healthDataRepository.save(new HealthDataEntity(98, 200, "M", "3", LocalDateTime.now(), user));
        List<HealthDataEntity> allByUser = healthDataRepository.findAllByUser(user);

        allByUser.sort(((o1, o2) ->
        {
            if(o1.getUpdateDate().isAfter(o2.getUpdateDate())) return -1;
            else if (o1.getUpdateDate().isEqual(o2.getUpdateDate())) return 0;
            else return 1;
        }));
        HealthDataEntity currentData = allByUser.get(0);
        double weeklySum = 0.0;
        double totalSum = 0.0;
        int weeklyCount = 0;
        int totalCount = 0;
        for (HealthDataEntity healthDataEntity : allByUser) {
            if (healthDataEntity.getUpdateDate().isAfter(currentData.getUpdateDate().minusDays(7))){
                weeklyCount++;
                weeklySum+=healthDataEntity.getWeight();
            }
            totalCount++;
            totalSum+=healthDataEntity.getWeight();
            System.out.println(healthDataEntity.getRowId() + ": " + healthDataEntity.getUpdateDate() + " - " + healthDataEntity.getWeight()) ;
        }
        System.out.println(weeklyCount + " " + totalCount);
        double weeklyProgress = (currentData.getWeight() - (weeklySum/weeklyCount))/(weeklySum/weeklyCount);
        weeklyProgress = Math.round(weeklyProgress*10000)/100.0;
        double totalProgress = (currentData.getWeight() - (totalSum/totalCount))/(totalSum/totalCount);
        totalProgress = Math.round(totalProgress*10000)/100.0;
        return new UserSummaryDTO(currentData.getGender(), currentData.getWeight(), currentData.getHeight(),weeklyProgress , totalProgress, 23.1, 2137.02);
    }

}
