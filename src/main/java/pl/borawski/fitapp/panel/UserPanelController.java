package pl.borawski.fitapp.panel;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.borawski.fitapp.data.HealthDataEntity;
import pl.borawski.fitapp.user.User;
import pl.borawski.fitapp.user.UserRepository;
import pl.borawski.fitapp.user.UserService;
import pl.borawski.fitapp.user.UserVerifyDTO;

import java.util.List;
import java.util.Optional;

@Controller
public class UserPanelController {
    UserPanelService userPanelService;
    UserService userService;
    UserRepository userRepository;

    public UserPanelController(UserPanelService userPanelService,UserService userService, UserRepository userRepository) {
        this.userPanelService = userPanelService;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    String home(Authentication authentication, Model model){
        System.out.println(authentication.getName());
        Optional<User> user = userRepository.findUserByMail(authentication.getName());
        if(user.isPresent()){
            UserSummaryDTO userSummaryDTO = userPanelService.testMethod(user.get());
            System.out.println(userSummaryDTO);
            model.addAttribute("UserData", userSummaryDTO);
      }
        return "index";
    }
}
/*
@Transactional
    public Optional<Double> getAvgPriceForCategory(long categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            Category existingCategory = category.get();
            List<Auction> auctions = existingCategory.getAuctions();
            double priceSum = auctions.stream().mapToDouble(Auction::getBuyNowPrice).sum();
            double avgPrice = priceSum / auctions.size();
            return Optional.of(avgPrice);
        } else {
            return Optional.empty();
        }
    }
 */
