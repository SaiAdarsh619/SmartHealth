package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* JADX INFO: Access modifiers changed from: package-private */
@ElementTypesAreNonnullByDefault
/* loaded from: classes14.dex */
public abstract class Dispatcher {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void dispatch(Object obj, Iterator<Subscriber> it);

    Dispatcher() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Dispatcher perThreadDispatchQueue() {
        return new PerThreadQueuedDispatcher();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Dispatcher legacyAsync() {
        return new LegacyAsyncDispatcher();
    }

    static Dispatcher immediate() {
        return ImmediateDispatcher.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public static final class PerThreadQueuedDispatcher extends Dispatcher {
        private final ThreadLocal<Boolean> dispatching;
        private final ThreadLocal<Queue<Event>> queue;

        private PerThreadQueuedDispatcher() {
            this.queue = new ThreadLocal<Queue<Event>>(this) { // from class: com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // java.lang.ThreadLocal
                public Queue<Event> initialValue() {
                    return Queues.newArrayDeque();
                }
            };
            this.dispatching = new ThreadLocal<Boolean>(this) { // from class: com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.2
                /* JADX INFO: Access modifiers changed from: protected */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.lang.ThreadLocal
                public Boolean initialValue() {
                    return false;
                }
            };
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0054 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0038 A[Catch: all -> 0x005f, LOOP:1: B:7:0x0038->B:9:0x0042, LOOP_START, TryCatch #0 {all -> 0x005f, blocks: (B:5:0x002f, B:7:0x0038, B:9:0x0042), top: B:16:0x002f }] */
        @Override // com.google.common.eventbus.Dispatcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void dispatch(java.lang.Object r5, java.util.Iterator<com.google.common.eventbus.Subscriber> r6) {
            /*
                r4 = this;
                com.google.common.base.Preconditions.checkNotNull(r5)
                com.google.common.base.Preconditions.checkNotNull(r6)
                java.lang.ThreadLocal<java.util.Queue<com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$Event>> r0 = r4.queue
                java.lang.Object r0 = r0.get()
                java.util.Queue r0 = (java.util.Queue) r0
                com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$Event r1 = new com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$Event
                r2 = 0
                r1.<init>(r5, r6)
                r0.offer(r1)
                java.lang.ThreadLocal<java.lang.Boolean> r1 = r4.dispatching
                java.lang.Object r1 = r1.get()
                java.lang.Boolean r1 = (java.lang.Boolean) r1
                boolean r1 = r1.booleanValue()
                if (r1 != 0) goto L6b
                java.lang.ThreadLocal<java.lang.Boolean> r1 = r4.dispatching
                r2 = 1
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
                r1.set(r2)
            L2f:
                java.lang.Object r1 = r0.poll()     // Catch: java.lang.Throwable -> L5f
                com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$Event r1 = (com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.Event) r1     // Catch: java.lang.Throwable -> L5f
                r2 = r1
                if (r1 == 0) goto L54
            L38:
                java.util.Iterator r1 = com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.Event.access$400(r2)     // Catch: java.lang.Throwable -> L5f
                boolean r1 = r1.hasNext()     // Catch: java.lang.Throwable -> L5f
                if (r1 == 0) goto L2f
                java.util.Iterator r1 = com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.Event.access$400(r2)     // Catch: java.lang.Throwable -> L5f
                java.lang.Object r1 = r1.next()     // Catch: java.lang.Throwable -> L5f
                com.google.common.eventbus.Subscriber r1 = (com.google.common.eventbus.Subscriber) r1     // Catch: java.lang.Throwable -> L5f
                java.lang.Object r3 = com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.Event.access$500(r2)     // Catch: java.lang.Throwable -> L5f
                r1.dispatchEvent(r3)     // Catch: java.lang.Throwable -> L5f
                goto L38
            L54:
                java.lang.ThreadLocal<java.lang.Boolean> r1 = r4.dispatching
                r1.remove()
                java.lang.ThreadLocal<java.util.Queue<com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$Event>> r1 = r4.queue
                r1.remove()
                goto L6b
            L5f:
                r1 = move-exception
                java.lang.ThreadLocal<java.lang.Boolean> r2 = r4.dispatching
                r2.remove()
                java.lang.ThreadLocal<java.util.Queue<com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$Event>> r2 = r4.queue
                r2.remove()
                throw r1
            L6b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.dispatch(java.lang.Object, java.util.Iterator):void");
        }

        /* loaded from: classes14.dex */
        private static final class Event {
            private final Object event;
            private final Iterator<Subscriber> subscribers;

            private Event(Object event, Iterator<Subscriber> subscribers) {
                this.event = event;
                this.subscribers = subscribers;
            }
        }
    }

    /* loaded from: classes14.dex */
    private static final class LegacyAsyncDispatcher extends Dispatcher {
        private final ConcurrentLinkedQueue<EventWithSubscriber> queue;

        private LegacyAsyncDispatcher() {
            this.queue = Queues.newConcurrentLinkedQueue();
        }

        @Override // com.google.common.eventbus.Dispatcher
        void dispatch(Object event, Iterator<Subscriber> subscribers) {
            Preconditions.checkNotNull(event);
            while (subscribers.hasNext()) {
                this.queue.add(new EventWithSubscriber(event, subscribers.next()));
            }
            while (true) {
                EventWithSubscriber e = this.queue.poll();
                if (e == null) {
                    return;
                }
                e.subscriber.dispatchEvent(e.event);
            }
        }

        /* loaded from: classes14.dex */
        private static final class EventWithSubscriber {
            private final Object event;
            private final Subscriber subscriber;

            private EventWithSubscriber(Object event, Subscriber subscriber) {
                this.event = event;
                this.subscriber = subscriber;
            }
        }
    }

    /* loaded from: classes14.dex */
    private static final class ImmediateDispatcher extends Dispatcher {
        private static final ImmediateDispatcher INSTANCE = new ImmediateDispatcher();

        private ImmediateDispatcher() {
        }

        @Override // com.google.common.eventbus.Dispatcher
        void dispatch(Object event, Iterator<Subscriber> subscribers) {
            Preconditions.checkNotNull(event);
            while (subscribers.hasNext()) {
                subscribers.next().dispatchEvent(event);
            }
        }
    }
}
