package hia;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

public class Edge implements WritableComparable<Edge> {
	private String departureNode;
	private String arrivalNode;

	public String getDeparture() {
		return departureNode;
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		departureNode = in.readUTF();
		arrivalNode = in.readUTF();
	}

	@Override
	public void write(DataOutput out) throws IOException {
		out.writeUTF(departureNode);
		out.writeUTF(arrivalNode);
	}

	@Override
	public int compareTo(Edge o) {
		return (departureNode.compareTo(o.departureNode) != 0) ? departureNode.compareTo(o.departureNode) : arrivalNode.compareTo(o.arrivalNode);
	}
}
