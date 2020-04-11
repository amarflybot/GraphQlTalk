package com.vuclip.graphqltalk.sampleapp.service;

import com.github.javafaker.Faker;
import com.vuclip.graphqltalk.sampleapp.model.cms.Artist;
import com.vuclip.graphqltalk.sampleapp.model.cms.Content;
import com.vuclip.graphqltalk.sampleapp.model.subscription.Plan;
import com.vuclip.graphqltalk.sampleapp.model.subscription.Subscription;
import com.vuclip.graphqltalk.sampleapp.model.um.Address;
import com.vuclip.graphqltalk.sampleapp.model.um.User;
import com.vuclip.graphqltalk.sampleapp.repo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class DataLoader implements ApplicationRunner {

    private final Faker faker;
    private final ContentRepository contentRepository;
    private final ArtistRepository artistRepository;
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;
    private final PlanRepository planRepository;
    private final SubscriptionRepository subscriptionRepository;

    public DataLoader(final Faker faker, final ContentRepository contentRepository,
                      final ArtistRepository artistRepository, final AddressRepository addressRepository,
                      final UserRepository userRepository, final PlanRepository planRepository,
                      final SubscriptionRepository subscriptionRepository) {
        this.faker = faker;
        this.contentRepository = contentRepository;
        this.artistRepository = artistRepository;
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
        this.planRepository = planRepository;
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public void run(final ApplicationArguments args) throws Exception {
        log.info("Starting data loading!!");

        subscriptionRepository.save(Subscription.builder()
                .startDate(faker.date().past(30, TimeUnit.DAYS))
                .endDate(faker.date().future(90,TimeUnit.DAYS))
                .plan(planRepository.save(getPlan("Monthly Plan", "Monthly")))
                .build());

        subscriptionRepository.save(Subscription.builder()
                .startDate(faker.date().past(3, TimeUnit.DAYS))
                .endDate(faker.date().future(4,TimeUnit.DAYS))
                .plan(planRepository.save(getPlan("Weekly Plan", "Weekly")))
                .build());

        subscriptionRepository.save(Subscription.builder()
                .startDate(faker.date().past(30, TimeUnit.DAYS))
                .endDate(faker.date().future(335,TimeUnit.DAYS))
                .plan(planRepository.save(getPlan("Yearly Plan", "Yearly")))
                .build());



        for (int i = 0; i < 30; i++) {
            artistRepository.save(getArtist());
            addressRepository.save(getAddress());
        }

        for (int i = 0; i < 10; i++) {
            contentRepository.save(getContent());
            userRepository.save(getUser());
        }

        for (int i = 0; i < 100; i++) {
            contentRepository.findById(Long.valueOf(i)).ifPresent(content -> {
                final List<Artist> artists = artistRepository.findAll(PageRequest.of(faker.number().numberBetween(0,10), faker.number().numberBetween(1,3))).getContent();
                log.info("ContentId: {} Artists size {}", content.getId(), artists.size());
                content.setArtists(artists);
                contentRepository.save(content);
            });

            userRepository.findById(Long.valueOf(i)).ifPresent(user -> {
                final List<Address> addresses = addressRepository.findAll(PageRequest.of(faker.number().numberBetween(0,10), faker.number().numberBetween(1,3))).getContent();
                log.info("userId: {} addresses size {}", user.getId(), addresses.size());
                user.setAddresses(addresses);
                final List<Content> contents = contentRepository.findAll(PageRequest.of(faker.number().numberBetween(0,5), faker.number().numberBetween(1,2))).getContent();
                log.info("userId: {} contents size {}", user.getId(), contents.size());
                user.setRecentlyWatched(contents);
                user.setSubscription(getSubscription());
                userRepository.save(user);
            });

        }

        log.info("Ended data loading!!");
    }

    private List<Subscription> getSubscription() {
        final List<Subscription> givenList = subscriptionRepository.findAll();
        final Random rand = new Random();
        return Arrays.asList(givenList.get(rand.nextInt(givenList.size())));
    }

    private Plan getPlan(final String name, final String type) {
        return Plan.builder()
                .name(name)
                .type(type)
                .planPrice(faker.number().randomDouble(2, 100, 200)).build();
    }

    private User getUser() {
        return User.builder()
                .name(faker.name().fullName())
                .placeOfBirth(faker.address().cityName())
                .gender(getGender())
                .dateOfBirth(faker.date().birthday(15,25))
                .build();
    }

    private Address getAddress() {
        return Address.builder()
                .streetName(faker.address().streetName())
                .streetAddressNumber(faker.address().streetAddressNumber())
                .streetAddress(faker.address().streetAddress())
                .country(faker.address().country())
                .city(faker.address().city())
                .zipCode(faker.address().zipCode())
                .build();
    }

    private Content getContent() {
        return Content.builder().title(faker.book().title()).description(faker.book().publisher()).genre(faker.book().genre()).thumbnail(faker.avatar().image()).build();
    }

    private Artist getArtist() {
        return Artist.builder().name(faker.artist().name()).gender(getGender()).dateOfBirth(faker.date().birthday(20,50)).awardWon(getAward()).build();
    }


    public String getGender() {
        final List<String> givenList = Arrays.asList("Male","Female");
        final Random rand = new Random();
        return givenList.get(rand.nextInt(givenList.size()));
    }
    public String getAward() {
        final List<String> givenList = Arrays.asList("92nd Academy Awards","Golden Disc Awards","Annual Grammy Awards","Global Award");
        final Random rand = new Random();
        return givenList.get(rand.nextInt(givenList.size()));
    }
}
