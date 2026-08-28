class BrowserHistory {
    private Page current;

    public BrowserHistory(String homepage) {
        this.current = new Page(homepage);
    }
    
    public void visit(String url) {
        current.next = new Page(url, null, current);
        current = current.next;
    }
    
    public String back(int steps) {
        Page temp = current;
        int i = 0;
        while (i < steps && current.prev != null) {
            current = current.prev;
            i++;
        }
        return current.url;
    }
    
    public String forward(int steps) {
        int i = 0;
        while (i < steps && current.next != null) {
            current = current.next;
            i++;
        }
        return current.url;
    }

    private class Page {
        String url;
        Page next;
        Page prev;

        Page(String url) {
            this(url, null, null);
        }

        Page(String url, Page next, Page prev) {
            this.url = url;
            this.next = next;
            this.prev = prev;
        }
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */