package hia;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.Partitioner;

public class EdgePartitioner implements Partitioner<Edge, Writable> {
	@Override
	public void configure(JobConf conf) {
	}

	@Override
	public int getPartition(Edge key, Writable value, int numPartitions) {
		return key.getDeparture().hashCode() % numPartitions;
	}
}
