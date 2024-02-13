package levelcache;

public abstract class ProcessCache {
    ILevelCache nextLevelCache;

    public ProcessCache(ILevelCache nextLevelCache) {
        this.nextLevelCache = nextLevelCache;
    }

    public ProcessCache() {
    }
}
