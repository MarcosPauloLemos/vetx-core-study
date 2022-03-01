package com.marcos.vertex.vertex_starter_study.eventbus;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class PublishSubscribeExample {

  public static void main(String[] args) {
    var vertx = Vertx.vertx();
    vertx.deployVerticle(new Publish());
    vertx.deployVerticle(new Substriber1());
    vertx.deployVerticle(Substriber2.class.getName(), new DeploymentOptions().setInstances(2));
  }

  public static class Publish extends AbstractVerticle {
    @Override
    public void start(Promise<Void> startPromise) throws Exception {
      startPromise.complete();
      vertx.setPeriodic(Duration.ofSeconds(10).toMillis(), id -> {
        vertx.eventBus().publish(Publish.class.getName(), "A message for everyone!");
      });
    }
  }

  public static class Substriber1 extends AbstractVerticle {

    private static final Logger LOG = LoggerFactory.getLogger(Substriber1.class);

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
      startPromise.complete();
      vertx.eventBus().consumer(Publish.class.getName(), message -> {
        LOG.debug("Received: {}", message.body());
      });
    }
  }

  public static class Substriber2 extends AbstractVerticle {

    private static final Logger LOG = LoggerFactory.getLogger(Substriber2.class);

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
      startPromise.complete();
      vertx.eventBus().consumer(Publish.class.getName(), message -> {
        LOG.debug("Received: {}", message.body());
      });
    }
  }
}
