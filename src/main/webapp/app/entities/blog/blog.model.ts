export interface IBlog {
  id?: number;
  name?: string;
  handle?: string;
  status?: boolean | null;
  description?: string | null;
}

export class Blog implements IBlog {
  constructor(
    public id?: number,
    public name?: string,
    public handle?: string,
    public status?: boolean | null,
    public description?: string | null
  ) {
    this.status = this.status ?? false;
  }
}

export function getBlogIdentifier(blog: IBlog): number | undefined {
  return blog.id;
}
