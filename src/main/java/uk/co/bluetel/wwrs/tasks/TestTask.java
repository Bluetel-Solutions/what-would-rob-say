package uk.co.bluetel.wwrs.tasks;

import com.google.common.collect.ImmutableMultimap;
import io.dropwizard.servlets.tasks.Task;

import java.io.PrintWriter;

public class TestTask extends Task {

    public TestTask() {
        super("test");
    }

    @Override
    public void execute(
       ImmutableMultimap<String, String> params,
       PrintWriter output
    ) throws Exception
    {
        output.print("Done test task");
    }
}
