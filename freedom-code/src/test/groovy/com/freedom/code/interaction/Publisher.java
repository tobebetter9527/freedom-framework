package com.freedom.code.interaction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tobebetter9527
 * @description TODO
 * @create 2021/05/10 22:23
 */
public class Publisher {

  private List<Subscriber> subscribers = new ArrayList<>();
  private int messageCount = 0;

  public void send(String message) {
    for (Subscriber subscriber : subscribers) {
      subscriber.receive(message);
    }
    messageCount++;
  }

  public List<Subscriber> getSubscribers() {
    return subscribers;
  }

  public void setSubscribers(List<Subscriber> subscribers) {
    this.subscribers = subscribers;
  }

  public int getMessageCount() {
    return messageCount;
  }

  public void setMessageCount(int messageCount) {
    this.messageCount = messageCount;
  }
}

