import React, { Component } from 'react';

class Posts extends Component {
    constructor(props) {
        super(props);

        this.state = {
            posts: [],
            hasError: false
        };
    }


    loadPosts() {
        fetch('https://jsonplaceholder.typicode.com/posts')
            .then(response => {
                if (!response.ok) {
                    throw new Error('Failed to fetch posts from network');
                }
                return response.json();
            })
            .then(data => {

                this.setState({ posts: data });
            })
            .catch(error => {
                console.error("Fetch error caught: ", error);
            });
    }


    componentDidMount() {
        this.loadPosts();
    }


    componentDidCatch(error, info) {
        this.setState({ hasError: true });
        alert(`An error occurred inside the component: ${error.message}`);
    }

    render() {
        if (this.state.hasError) {
            return (
                <div style={{ textAlign: 'center', marginTop: '50px' }}>
                    <h2 style={{ color: '#e74c3c' }}>Something went wrong loading the posts.</h2>
                </div>
            );
        }

        return (
            <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
                <h2 style={{ textAlign: 'center', color: '#2c3e50', marginBottom: '20px' }}>
                    Latest Blog Posts
                </h2>
                <hr style={{ border: '1px solid #eee', marginBottom: '30px' }} />

                <div style={{ maxWidth: '800px', margin: '0 auto' }}>
                    {this.state.posts.map(post => (
                        <div
                            key={post.id}
                            style={{
                                marginBottom: '25px',
                                padding: '20px',
                                borderRadius: '8px',
                                backgroundColor: '#fdfdfd',
                                boxShadow: '0 2px 5px rgba(0,0,0,0.05)',
                                borderLeft: '5px solid #3498db'
                            }}
                        >
                            <h3 style={{ color: '#2c3e50', textTransform: 'capitalize', marginTop: '0' }}>
                                {post.title}
                            </h3>
                            <p style={{ color: '#7f8c8d', lineHeight: '1.6', marginBottom: '0' }}>
                                {post.body}
                            </p>
                        </div>
                    ))}
                </div>
            </div>
        );
    }
}

export default Posts;