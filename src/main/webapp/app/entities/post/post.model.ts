import * as dayjs from 'dayjs';

export interface IPost {
  id?: number;
  title?: string;
  content?: string;
  date?: dayjs.Dayjs;
}

export class Post implements IPost {
  constructor(public id?: number, public title?: string, public content?: string, public date?: dayjs.Dayjs) {}
}

export function getPostIdentifier(post: IPost): number | undefined {
  return post.id;
}
