package com.livebycode.flink.helloflink;

import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.sink.PrintSinkFunction;

public class Application {
  public static void main(String[] args) throws Exception {

    /* Create Flink Environment*/
    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

    /* Setup source for job*/
    DataStreamSource<Long> source = env.generateSequence(0L, 1000000L);
    /* Setup job pipeline*/
    SingleOutputStreamOperator<String> stream = source.map(e -> e.toString());
    /* Setup Sink for job*/
    stream.addSink(new PrintSinkFunction<>());

    /*Start processing*/
    env.execute();
  }
}
