import {Queue} from '../src/queue';

test('queue length', () => {
  const queue = new Queue();
  expect(queue.getLength()).toBe(0);

  const item = {foo: 'bar'};
  queue.enqueue(item);
  expect(queue.getLength()).toBe(1);

  queue.dequeue();
  expect(queue.getLength()).toBe(0);
});

test('dequeued', () => {
  const queue = new Queue();
  const itemA = {foo: 'bar'};
  const itemB = {x: 'y'};

  queue.enqueue(itemA);
  queue.enqueue(itemB);

  expect(queue.dequeue()).toBe(itemA);
  expect(queue.dequeue()).toBe(itemB);
});

test('empty', () => {
  const queue = new Queue();

  queue
      .enqueue('a')
      .enqueue('b')
      .enqueue('c');

  queue.dequeue();
  queue.dequeue();
  queue.dequeue();

  expect(queue.isEmpty()).toBe(true);
});

test('items can be enqueued', () => {
  const queue = new Queue();

  queue
      .enqueue('1')
      .enqueue('2')
      .enqueue('3');

  expect(queue.toString()).toBe('1,2,3');
});