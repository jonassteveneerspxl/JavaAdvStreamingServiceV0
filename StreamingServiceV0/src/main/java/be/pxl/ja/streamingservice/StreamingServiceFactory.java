package be.pxl.ja.streamingservice;

public class StreamingServiceFactory {
	private static StreamingService streamingService = new StreamingService();

	public static StreamingService getStreamingService() {
		return streamingService;
	}

}
