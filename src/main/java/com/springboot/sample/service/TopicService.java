package com.springboot.sample.service;

import com.springboot.sample.model.Topic;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TopicService {

    private static final List<Topic> topics = new ArrayList<>();
    private static final Random random = new Random(40);

    static {
        topics.add(createTopic(1, "CORE JAVA"));
        topics.add(createTopic(2, "SPRING BOOT"));
        topics.add(createTopic(3, "JAVA SCRIPT"));
        topics.add(createTopic(4, "RDBMS/SQL"));
    }

    public List<Topic> getAllTopics(){
        return new ArrayList<>(topics);
    }

    private static Topic createTopic(int id, String name){
        Topic t = new Topic();
        Calendar startCal = Calendar.getInstance();
        Calendar endCal = Calendar.getInstance();
        endCal.add(Calendar.DATE, random.nextInt(100));
        t.setId(id);
        t.setName(name);
        t.setStart(new Date(startCal.getTimeInMillis()));
        t.setEnd(new Date(endCal.getTimeInMillis()));
        float diff = (((((endCal.getTimeInMillis() - startCal.getTimeInMillis())/1000)/60)/60)/24);
        t.setDuration(diff);

        return t;
    }

    public Topic getATopic(Integer id) {

        Topic topic = null;
        for (Topic t: topics) {
            if (t.getId() == id) {
                try {
                    topic = (Topic) t.clone();
                    break;
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        }

        return topic;
    }

    public Topic addTopic(Topic topic) {
        topic.setId(topics.size() ==0 ? 1 : topics.get(topics.size()-1).getId() +1);
        topics.add(topic);
        return topic;
    }
}
