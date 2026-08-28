class BrowserHistory {
    private Page current;

    public BrowserHistory(String homepage) {
        this.current = new Page(homepage);
    }
    
    public void visit(String url) {
        Page newPage = new Page(url, null, current);
        current.next = newPage;
        current = current.next;
    }
    
    public String back(int steps) {
        Page temp = current;
        int i = 0;
        while (i < steps && temp.prev != null) {
            temp = temp.prev;
            i++;
        }
        current = temp;
        return current.url;
    }
    
    public String forward(int steps) {
        Page temp = current;
        int i = 0;
        while (i < steps && temp.next != null) {
            temp = temp.next;
            i++;
        }
        current = temp;
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