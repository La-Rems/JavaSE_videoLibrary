package videoLibrary;

import videoLibrary.service.VideoLibraryService;

public class VideoLibraryApplication {

    public static void main(String[] args) {
        VideoLibraryService videoLibraryService = new VideoLibraryService();
        videoLibraryService.run();
    }
}
